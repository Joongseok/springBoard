package kr.or.ddit.board.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVO;

public class BoardControllerTest extends ControllerTestEnv{

	/**
	* Method : boardManager
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 게시판 메인 테스트
	 * @throws Exception 
	*/
	@Test
	public void boardManagerTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/board/boardManager")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("tiles.boardManager", viewName);
	}
	
	/**
	* Method : createBoard
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 게시판 생성 테스트
	 * @throws Exception 
	*/
	@Test
	public void createBoardTest() throws Exception {
		/***Given***/
		/***When***/
		UserVO userVo = new UserVO();
		userVo.setUserId("brown");
		MvcResult mvcResult = mockMvc.perform(post("/board/createBoard")
									.param("createBoardName", "테스트 게시판 생성이름")
									.param("use_yn", "true").
									sessionAttr("USER_INFO", userVo)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("redirect:/board/boardManager", viewName);
	}
	
	/**
	 * Method : boardManager
	 * 작성자 : PC25
	 * 변경이력 :
	 * Method 설명 : 게시판 메인 테스트
	 * @throws Exception 
	 */
	@Test
	public void updateBoardTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/board/updateBoard")
									.param("id", "1")
									.param("updateUse_yn", "true")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("redirect:/board/boardManager", viewName);
	}

}
