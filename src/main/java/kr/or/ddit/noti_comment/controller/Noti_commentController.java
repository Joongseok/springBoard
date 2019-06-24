package kr.or.ddit.noti_comment.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.user.model.UserVO;

//@WebServlet("/noti_comment")
@Controller
public class Noti_commentController  {
    
	@Resource(name = "noti_CommentService")
	private INoti_CommentService noti_commentService;
	
	@RequestMapping(path = "/noti_comment", method = RequestMethod.POST)
	public String noti_comment_Main(String cntNotiId, String comment, HttpServletRequest request) {
		
		int notiId = Integer.parseInt(cntNotiId); 
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		int id = noti_commentService.commentAllCnt() == 0 ? 1 : noti_commentService.commentMaxId(); 
		Noti_commentVO ntcVo = new Noti_commentVO(id, notiId, userId, comment);
		noti_commentService.insertComment(ntcVo);
		return "redirect:noticeDetail?notiId=" + notiId;
		
	}
	
	@RequestMapping(path = "/deleteComment", method = RequestMethod.GET)
	public String deleteComment(String notiId, String id, HttpServletRequest request) {
		
		int ntcId = Integer.parseInt(id); 
		int noticeId = Integer.parseInt(notiId); 
		noti_commentService.deleteCmt(ntcId);
		
		return "redirect:noticeDetail?notiId=" + noticeId;
		
	}

	
	
}
