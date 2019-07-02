package kr.or.ddit.noti_comment.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.user.model.UserVO;

@RequestMapping("/noti_commnet")
@Controller
public class Noti_commentController  {
    
	@Resource(name = "noti_CommentService")
	private INoti_CommentService noti_commentService;
	
	/**
	* Method : noti_comment_Main
	* 작성자 : PC25
	* 변경이력 :
	* @param cntNotiId
	* @param comment
	* @param request
	* @return
	* Method 설명 : 댓글 등록
	*/
	@RequestMapping(path = "/createComment", method = RequestMethod.POST)
	public String noti_commentCreate(int cntNotiId, String comment
			, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		// 세션에 담긴 유저의 아이디
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		
		// 댓글의 개수가 0이면 임의로 1을 없으면 가장 높은 번호 + 1
		int id = noti_commentService.commentAllCnt() == 0 ? 1 : noti_commentService.commentMaxId(); 
		
		// 댓글 생성
		Noti_commentVO ntcVo = new Noti_commentVO(id, cntNotiId, userId, comment);
		noti_commentService.insertComment(ntcVo);
		
		redirectAttributes.addAttribute("notiId", cntNotiId);
		return "redirect:/notice/noticeDetail";
		
	}
	
	
	/**
	* Method : deleteComment
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @param id
	* @param request
	* @return
	* Method 설명 : 댓글 삭제
	*/
	@RequestMapping(path = "/deleteComment", method = RequestMethod.GET)
	public String deleteComment(int notiId, int id
				,RedirectAttributes redirectAttributes , HttpServletRequest request) {
		
		// 댓글 삭제
		noti_commentService.deleteCmt(id);
		
		redirectAttributes.addAttribute("notiId", notiId);
		return "redirect:/notice/noticeDetail";
		
	}

	
	
}
