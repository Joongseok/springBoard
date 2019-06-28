package kr.or.ddit.login.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;

public class LoginControllerTest extends ControllerTestEnv{
	
	

	@Test
	public void loginViewNotLoginedTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("login/login", viewName);
	}
	

	@Test
	public void loginProcessSucessTest() throws Exception{
		String userId = "brown";
		String password = "brown1234";
		
		MvcResult mvcResult = mockMvc.perform(post("/login")
							.param("userId", userId)
							.param("pass", password))
							.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		
		assertEquals("tiles.main", viewName);
	}
		
	
}
