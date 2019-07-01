package kr.or.ddit.notice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.PartUtil;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	@Resource(name = "noticeService")
	private INoticeService noticeService;
	
	@Resource(name = "noti_CommentService")
	private INoti_CommentService ntcService;
	
	@Resource(name = "uploadFileService")
	private IUploadFileService uploadFileService;
	
	@Resource(name =  "boardService")
	private IBoardService boardService;
	
	/**
	* Method : noticeController
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @param pageVo
	* @param model
	* @return
	* Method 설명 : 게시글 페이징 리스트
	*/
	@RequestMapping(path = "/noticeController", method = RequestMethod.GET)
	public String noticeController(int id,  
			@RequestParam(name = "selected", defaultValue = "content")String selected, 
			@RequestParam(name = "search", defaultValue = "") String search,
			PageVO pageVo, Model model) {

		logger.debug("========================================Controller Start=============================================");
		logger.debug("Controller selected[" + selected + "]");
		logger.debug("Controller search[" + search + "]");
		logger.debug("Controller boardId[" + id + "]");
		logger.debug("Controller page[" + pageVo.getPage() + "]");
		logger.debug("Controller pageSize[" + pageVo.getPageSize()+ "]");
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("selected", selected);
		pageMap.put("search", search);
		pageMap.put("id", id);
		pageMap.put("page", pageVo.getPage());
		pageMap.put("pageSize", pageVo.getPageSize());
		
		
		Map<String, Object> resultMap = noticeService.noticePagingList(pageMap);
		int paginationSize = (int) resultMap.get("paginationSize");
		
		logger.debug("Controller paginationSize[" + paginationSize + "]");
		List<NoticeVO> noticeList = (List<NoticeVO>) resultMap.get("noticeList");
		logger.debug("Controller noticeList[" + noticeList + "]");
		
		model.addAttribute("pageMap", pageMap);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("boardVo", boardService.getBoard(id));
		
		logger.debug("========================================Controller End=============================================");
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
		Map<String, Object> notiDeatilMap = noticeService.getNotice(notiId);
		
		model.addAttribute("notiDeatilMap", notiDeatilMap);
		
		// 조회 화면으로 이동
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
		model.addAttribute("fileId", fileId);
		logger.debug("fileDownload : {}", fileId);
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
		logger.debug("id : {}", id);
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		int notiId = noticeService.noticeAllCnt() == 0 ? 1 : noticeService.noticeMaxId();
		
		NoticeVO noticeVo = new NoticeVO(notiId, userId, title, smarteditor, id, notiId);
		noticeService.insertNotice(noticeVo);

		if(files != null) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, notiId);
			
			if(uploadFileList != null)
				uploadFileService.insertUploadFile(uploadFileList);
			
		}
		
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
		
		Map<String, Object> map = noticeService.getNotice(notiId);
		NoticeVO ntVo = (NoticeVO) map.get("noticeVo");
		
		List<Noti_commentVO> ntcList = ntcService.commentList(notiId);
		
		// 댓글리스트 삭제
		ntcService.deleteComment(ntcList);
		
		// 게시글 삭제
		noticeService.deleteNotice(notiId);
		
		redirectAttributes.addAttribute("id", ntVo.getId());
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
		
		Map<String, Object> map = noticeService.getNotice(notiId);
		NoticeVO noticeVo = (NoticeVO) map.get("noticeVo");
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		logger.debug("notiId : {}", notiId);
		
		int createNotiId = noticeService.noticeMaxId();
		
		NoticeVO createNoticeVo = new NoticeVO(createNotiId, userId, title, smarteditor, 
												notiId ,noticeVo.getId(), noticeVo.getGroupId());
		
		noticeService.replyNotice(createNoticeVo);
		
		if(files != null) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, createNotiId);
			
			if(uploadFileList != null)
				uploadFileService.insertUploadFile(uploadFileList);
			
		}
		
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
		
		Map<String, Object> map = noticeService.getNotice(notiId);
		NoticeVO noticeVo = (NoticeVO) map.get("noticeVo");
		List<UploadFileVO> fileList =  uploadFileService.getUploadFileList(notiId);
		
		model.addAttribute("noticeVo", noticeVo);
		model.addAttribute("fileList", fileList);
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
		
		List<UploadFileVO> dbUploadFileList = new ArrayList<UploadFileVO>();
		if(deleteFileId != null)
			for(String fileid : deleteFileId)
				if (fileid !=null) 
					dbUploadFileList.add(uploadFileService.getFileVo(fileid));
		
		if (dbUploadFileList.size() != 0) 
			uploadFileService.dbDeleteFile(dbUploadFileList);
		
		NoticeVO noticeVo = new NoticeVO(notiId, title, smarteditor);
		
		Map<String, Object> map = noticeService.getNotice(notiId);
		// 수정전 내용이 담긴 게시글 객체
		NoticeVO originallyNoticeVo = (NoticeVO) map.get("noticeVo");
		
		// 게시글 수정
		noticeService.updateNotice(noticeVo);
		
		if(files != null) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, notiId);
			
			if(uploadFileList != null)
				uploadFileService.insertUploadFile(uploadFileList);
			
		}
	
		redirectAttributes.addAttribute("notiId", notiId);
		return "redirect:/notice/noticeDetail";
	}

}
