package kr.or.ddit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVO;

@Service
public class UserService implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao; 
	@Override
	public UserVO getUser(String userId) {
		
		return userDao.getUser(userId);
	}
	
}
