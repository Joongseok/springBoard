package kr.or.ddit.noti_comment.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.testenv.LogicTestEnv;

public class Noti_CommentDaoTest extends LogicTestEnv{

	@Resource(name = "noti_commentDao")
	private INoti_CommentDao noti_commentDao;
	
	/**
	* Method : commentAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 전체 수 
	*/
	@Test
	public void commentAllCntTest() {
		/***Given***/
		/***When***/
		int noticeAllCnt = noti_commentDao.commentAllCnt();
		/***Then***/
		assertEquals(13, noticeAllCnt);
	}
	
	/**
	* Method : commentMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 댓글의 마지막 번호 + 1
	*/
	@Test
	public void commentMaxIdTest() {
		/***Given***/
		/***When***/
		int commentMaxId = noti_commentDao.commentMaxId();
		/***Then***/
		assertEquals(14, commentMaxId);
	}
	
	/**
	* Method : isertComment
	* 작성자 : PC25
	* 변경이력 :
	* @param ntcVo
	* @return
	* Method 설명 : 댓글 작성
	*/
	@Test
	public void insertCommentTest() {
		/***Given***/
		/***When***/
		Noti_commentVO ntcVo = new Noti_commentVO(14, 1, "cony", "테스트 대글");
		int result = noti_commentDao.insertComment(ntcVo);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	* Method : commentList
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 해당게시글의 댓글 리스트
	*/
	@Test
	public void commentListTest() {
		/***Given***/
		/***When***/
		List<Noti_commentVO> commentList = noti_commentDao.commentList(1);
		/***Then***/
		assertEquals(1, commentList.size());
	}
	
	/**
	* Method : deleteComment
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 해당 게시글 이 삭제되면 댓글도 전부 cascade
	*/
	@Test
	public void deleteCommentTest() {
		/***Given***/
		/***When***/
		int result = noti_commentDao.deleteComment(1);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	* Method : deleteCmt
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 해당 ID의 댓글 삭제
	*/
	@Test
	public void deleteCmtTest() {
		/***Given***/
		/***When***/
		int result = noti_commentDao.deleteCmt(1);
		/***Then***/
		assertEquals(1, result);
	}

}
