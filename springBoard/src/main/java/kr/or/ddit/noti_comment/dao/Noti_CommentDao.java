package kr.or.ddit.noti_comment.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.noti_comment.model.Noti_commentVO;

@Repository("noti_commentDao")
public class Noti_CommentDao implements INoti_CommentDao {

	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	/**
	* Method : commentAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 전체 수
	*/
	@Override
	public int commentAllCnt() {
		return sqlSession.selectOne("noti_comment.commentAllCnt");
	}

	/**
	* Method : commentMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 댓글의 마지막 번호
	*/
	@Override
	public int commentMaxId() {
		return sqlSession.selectOne("noti_comment.commentMaxId");
	}

	/**
	* Method : insertComment
	* 작성자 : PC25
	* 변경이력 :
	* @param ntcVo
	* @return
	* Method 설명 : 댓글 생성
	*/
	@Override
	public int insertComment(Noti_commentVO ntcVo) {
		return sqlSession.insert("noti_comment.insertComment", ntcVo);
	}

	/**
	* Method : commentList
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 댓글 리스트
	*/
	@Override
	public List<Noti_commentVO> commentList(int notiId) {
		return sqlSession.selectList("noti_comment.commentList", notiId);
	}

	/**
	* Method : deleteComment
	* 작성자 : PC25
	* 변경이력 :
	* @param sqlSession
	* @param ntcVo
	* @return
	* Method 설명 : 해당 게시글 이 삭제되면 댓글도 전부 cascade
	*/
	@Override
	public int deleteComment(int id) {
		return sqlSession.update("noti_comment.deleteComment", id);
	}

	/**
	* Method : deleteCmt
	* 작성자 : PC25
	* 변경이력 :
	* @param ntcId
	* @return
	* Method 설명 : ID에 해당하는 댓글 삭제
	*/
	@Override
	public int deleteCmt(int ntcId) {
		return sqlSession.update("noti_comment.deleteCmt", ntcId);
	}

}
