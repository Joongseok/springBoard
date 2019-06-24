package kr.or.ddit.user.service;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVO;


public class UserServiceTest extends LogicTestEnv{

	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	* Method : getUserTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVO userVo = userService.getUser(userId);
		/***Then***/
		assertNotNull(userVo);
	}

}
