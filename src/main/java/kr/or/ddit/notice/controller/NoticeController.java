package kr.or.ddit.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.user.model.UserVO;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	@Resource(name = "noticeService")
	private INoticeService noticeService;
	
	/**
	* Method : noticeController
	* 작성자 : PC25
	* 변경이력 :
	* @param id 게시판 아이디
	* @param pageVo page, pageSize
	* @param model
	* @return
	* Method 설명 : 게시글 페이징 리스트
	*/
	@RequestMapping("/noticeController")
	public String noticeController(int id,  
			@RequestParam(name = "selected", defaultValue = "content")String selected, 
			@RequestParam(name = "search", defaultValue = "") String search,
			PageVO pageVo, Model model) {

		// 사용자로부터 요청받은 정보를 담을 맵 객체
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		// selecteBox에서 선택한 검색 옵션(내용 or 제목)
		pageMap.put("selected", selected);
		
		// 검색 내용
		pageMap.put("search", search);
		
		// 게시판 아이디
		pageMap.put("id", id);
		
		// 페이지 번호
		pageMap.put("page", pageVo.getPage());
		
		// 한 페이지에 출력할 게시글 수
		pageMap.put("pageSize", pageVo.getPageSize());
		
		model.addAttribute("pageMap", pageMap);
		model.addAttribute("noticeList", (List<NoticeVO>) noticeService.noticePagingList(pageMap).get("noticeList"));
		model.addAttribute("paginationSize", (int) noticeService.noticePagingList(pageMap).get("paginationSize"));
		model.addAttribute("boardVo", (BoardVO)noticeService.noticePagingList(pageMap).get("boardVo"));
		
		return "tiles.noticePagingList";
	}
	
	/**
	* Method : NoticeDetail
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param request
	* @return
	* Method 설명 : 게시글 상세 조회
	*/
	@RequestMapping(path = "/noticeDetail", method = RequestMethod.GET)
	public String NoticeDetail(int notiId, Model model) {
		 	
		//	게시글 아이디에 해당하는 게시글의 내용, 첨부파일, 댓글 정보
		model.addAttribute("notiDeatilMap", (Map<String, Object>)noticeService.getNotice(notiId));
		
		return "tiles.noticeDetail";
	}
	
	/**
	* Method : NoticeDetailFileDownload
	* 작성자 : PC25
	* 변경이력 :
	* @param model
	* @param fileId
	* @return
	* Method 설명 : 파일 다운로드
	*/
	@RequestMapping("/fileDownload")
	public String NoticeDetailFileDownload(Model model, String fileId) {
		
		/*
		   application-context.xml에서 등록한 BeanNameViewResolver를 이용하여
		   Bean아이디가 fileDownloadView인 클래스로 fileId를 가지고 이동한다. 
		 */
		
		model.addAttribute("fileId", fileId);
		return "fileDownloadView";
	}
	
	/**
	* Method : NoticeFormGet
	* 작성자 : OWNER
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 등록 요청화면
	*/
	@RequestMapping(path = "/noticeForm", method = RequestMethod.GET)
	public String NoticeFormGet(int id, Model model) {
		
		// 게시판 번호
		model.addAttribute("id", id);
		return "tiles.noticeForm";
	}
	
	/**
	 * Method : NoticeFormGet
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 등록 응답화면
	 */
	@RequestMapping(path = "/noticeForm", method = RequestMethod.POST)
	public String NoticeFormPost(MultipartFile[] files ,int id,String title, String smarteditor, Model model, 
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		// 세션에 담겨있는 유저의 정보에서 userId를 입력
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		
		// 게시글이 하나도 없으면 게시글 아이디를 1으로 하고 있으면 게시글의 가장 높은 번호 + 1
		int notiId = noticeService.noticeAllCnt() == 0 ? 1 : noticeService.noticeMaxId();
		
		// 작성한 게시글의 정보를 담고있는 VO객체
		NoticeVO noticeVo = new NoticeVO(notiId, userId, title, smarteditor, id, notiId);
		
		// 게시글 등록
		noticeService.insertNotice(noticeVo, files);

		// 작성한 게시글 화면으로 이동한다.
		redirectAttributes.addAttribute("notiId", notiId);
		return "redirect:/notice/noticeDetail";
	}
	
	/**
	* Method : deleteNotice
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param redirectAttributes
	* @return
	* Method 설명 : 게시글 삭제
	*/
	@RequestMapping("/deleteNotice")
	public String deleteNotice(int notiId, RedirectAttributes redirectAttributes) {
		
		// 게시글 삭제
		noticeService.deleteNotice(notiId);
		
		// 현재 있는 게시판으로 이동
		redirectAttributes.addAttribute("id", ((NoticeVO) noticeService.getNotice(notiId).get("noticeVo")).getId());
		return "redirect:/notice/noticeController";
	}
	
	/**
	* Method : replyNoticeGet
	* 작성자 : OWNER
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 답글 요청 화면
	*/
	@RequestMapping(path = "/replyNotice", method = RequestMethod.GET)
	public String replyNoticeGet(int notiId, Model model) {
		model.addAttribute("notiId", notiId);
		return "tiles.replyNotice";
	}
	
	/**
	 * Method : replyNoticeGet
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 답글 응답 화면
	 */
	@RequestMapping(path = "/replyNotice", method = RequestMethod.POST)
	public String replyNoticePost(MultipartFile[] files ,String title ,int notiId,String smarteditor, 
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		// 답글을 작성할 게시글의 부모 게시글 정보
		NoticeVO noticeVo = (NoticeVO) noticeService.getNotice(notiId).get("noticeVo");
		
		// 세션에 담겨있는 로그인한 사용자 아이디
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		
		// 게시글 중 가장 높은 번호 + 1
		int createNotiId = noticeService.noticeMaxId();
		
		// 답글을 작성할 정보를 담은 VO객체
		NoticeVO createNoticeVo = new NoticeVO(createNotiId, userId, title, smarteditor, 
												notiId ,noticeVo.getId(), noticeVo.getGroupId());
		
		// 답글 작성
		noticeService.replyNotice(createNoticeVo, files);

		// 답글을 작성한 화면으로 이동
		redirectAttributes.addAttribute("notiId", createNotiId);
		return "redirect:/notice/noticeDetail";
	}
	
	/**
	* Method : updateNotice
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param model
	* @return
	* Method 설명 : 사용자 수정 요청화면
	*/
	@RequestMapping(path = "/updateNotice", method = RequestMethod.GET)
	public String updateNotice(int notiId, Model model) {
		
		// 게시글 아이디에 해당하는 게시글의 내용, 첨부파일을 map객체에 담는다.
		Map<String, Object> map = noticeService.getNotice(notiId);
		
		model.addAttribute("noticeVo", (NoticeVO) map.get("noticeVo"));
		model.addAttribute("fileList", (List<UploadFileVO>) map.get("uploadFileList"));
		return "tiles.updateNotice";
	}
	
	/**
	 * Method : updateNotice
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @param notiId
	 * @param model
	 * @return
	 * Method 설명 : 사용자 수정 응답화면
	 */
	@RequestMapping(path = "/updateNotice", method = RequestMethod.POST)
	public String updateNoticePost(String[] deleteFileId, int notiId, String title, 
					String smarteditor, Model model,MultipartFile[] files
					,RedirectAttributes redirectAttributes) {
		
		// 수정할 내용을 담은 VO객체
		NoticeVO noticeVo = new NoticeVO(notiId, title, smarteditor);
		
		// 게시글 내용, 첨부파일 수정
		noticeService.updateNotice(noticeVo, deleteFileId, files);
		
		// 수정한 게시글 상세화면으로 이동
		redirectAttributes.addAttribute("notiId", notiId);
		return "redirect:/notice/noticeDetail";
	}

}
