package kr.or.ddit.noti_comment.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.user.model.UserVO;

//@WebServlet("/noti_comment")
@Controller
public class Noti_commentController  {
    
	@Resource(name = "noti_CommentService")
	private INoti_CommentService noti_commentService;
	
	public String noti_comment_Main(String cntNotiId, String comment, HttpServletRequest request) {
		
		int notiId = Integer.parseInt(cntNotiId); 
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		int id = noti_commentService.commentAllCnt() == 0 ? 1 : noti_commentService.commentMaxId(); 
		Noti_commentVO ntcVo = new Noti_commentVO(id, notiId, userId, comment);
		noti_commentService.insertComment(ntcVo);
		return "redirect:noticeDetail";
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8"); 
		String notiIdStr = request.getParameter("cntNotiId");
		
		// 게시글 아이디
		int notiId = Integer.parseInt(notiIdStr); 
		
		// 댓글 내용
		String comment = request.getParameter("comment"); 
		
		//댓글 작성자
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();

		// 댓글 번호
		int id = noti_commentService.commentAllCnt() == 0 ? 1 : noti_commentService.commentMaxId(); 
		
		Noti_commentVO ntcVo = new Noti_commentVO(id, notiId, userId, comment);
		
		// 댓글 insert
		noti_commentService.insertComment(ntcVo);
		
		// 해당 게시글로 돌아감
		response.sendRedirect(request.getContextPath() + "/noticeDetail?notiId="+notiId);
	}

}
