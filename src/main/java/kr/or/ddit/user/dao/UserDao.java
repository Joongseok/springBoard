package kr.or.ddit.user.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVO;

@Repository
public class UserDao implements IUserDao {

	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	@Override
	public UserVO getUser(String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}

}
