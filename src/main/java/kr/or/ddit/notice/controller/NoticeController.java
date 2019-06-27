package kr.or.ddit.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;

@Controller
public class NoticeController {
	
	@Resource(name = "noticeService")
	private INoticeService noticeService;
	
	@Resource(name = "noti_CommentService")
	private INoti_CommentService ntcService;
	
	@Resource(name = "uploadFileService")
	private IUploadFileService uploadFileService;
	
	
	@RequestMapping(path = "/noticeController", method = RequestMethod.GET)
	public String noticeController(String id, String page, String pageSize, HttpServletRequest request) {
		int boardId = Integer.parseInt(id);
		
		int pages = page == null ? 1 : Integer.parseInt(page);
		int pagesi = pageSize == null ? 10 : Integer.parseInt(pageSize);
		
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("id", boardId);
		pageMap.put("page", pages);
		pageMap.put("pageSize", pagesi);
		
		Map<String, Object> resultMap = noticeService.noticePagingList(pageMap);
		int paginationSize = (int) resultMap.get("paginationSize");
		if (paginationSize == 0) {
			paginationSize = 1;
		}
		List<NoticeVO> noticeList = (List<NoticeVO>) resultMap.get("noticeList");
		
		request.setAttribute("pageMap", pageMap);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("paginationSize", paginationSize);
		
		return "noticePagingList";
	}
	
	@RequestMapping(path = "/noticeDetail", method = RequestMethod.GET)
	public String NoticeDetail(String notiId, HttpServletRequest request) {
		
		int notiIds = Integer.parseInt(notiId);
		
		
		// 서비스에서 한번에 처리하는 로직으로 바꾸기
		NoticeVO noticeVo = noticeService.getNotice(notiIds);
		
		List<UploadFileVO> uploadFileList =  uploadFileService.getUploadFileList(notiIds);
		
		// 게시글 번호에 해당하는 댓글 리스트
		List<Noti_commentVO> ntcList = ntcService.commentList(notiIds);
				
		request.setAttribute("noticeVo", noticeVo);
		request.setAttribute("uploadFileList", uploadFileList);
		request.setAttribute("ntcList", ntcList);
		
		// 조회 화면으로 이동
		return "notice/noticeDetail";
	}
	
		

}
