package kr.or.ddit.noti_comment.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVO;

public class Noti_commentControllerTest extends ControllerTestEnv{

	
	/**
	* Method : noti_comment_Main
	* 작성자 : PC25
	* 변경이력 :
	* @param cntNotiId
	* @param comment
	* @param request
	* @return
	* Method 설명 : 댓글 등록 테스트
	 * @throws Exception 
	*/
	@Test
	public void noti_commentCreateTest() throws Exception {
		/***Given***/
		/***When***/
		UserVO userVo = new UserVO();
		userVo.setUserId("brown");
		MvcResult mvcResult = mockMvc.perform(post("/noti_commnet/createComment")
							.param("cntNotiId", "1")
							.param("comment", "테스트 댓글 내용")
							.sessionAttr("USER_INFO", userVo)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		String notiId = (String) mav.getModelMap().get("notiId");
		/***Then***/
		assertEquals("redirect:/notice/noticeDetail", viewName);
		assertEquals("1", notiId);
	}
	
	/**
	* Method : deleteComment
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @param id
	* @param request
	* @return 
	* Method 설명 : 댓글 삭제 테스트
	 * @throws Exception 
	*/
	@Test
	public void deleteCommentTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/noti_commnet/deleteComment")
										.param("notiId", "1")
										.param("id", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName(); 
		String notiId = (String) mav.getModelMap().get("notiId");
		/***Then***/
		assertEquals("redirect:/notice/noticeDetail", viewName);
		assertEquals("1", notiId);
	}

}
