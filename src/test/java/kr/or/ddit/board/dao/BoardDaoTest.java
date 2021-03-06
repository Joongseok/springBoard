package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.testenv.LogicTestEnv;

public class BoardDaoTest extends LogicTestEnv{

	
	@Resource(name = "boardDao")
	private IBoardDao boardDao;
	
	/**
	* Method : boardsCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 수  +1 테스트
	*/
	@Test
	public void boardCntTest() {
		/***Given***/
		/***When***/
		int boardCnt = boardDao.boardCnt();
		/***Then***/
		assertEquals(4, boardCnt);
	}
	/**
	* Method : insertBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성 테스트
	*/
	@Test
	public void insertBoard() {
		/***Given***/
		/***When***/
		BoardVO boardVo = new BoardVO(4, "brown", "테스트게시판 이름", "true"); 
		int result = boardDao.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, result);
	}
	/**
	* Method : boardList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용여부가 true인 boardList 조회
	*/
	@Test
	public void boardList() {
		/***Given***/
		/***When***/
		List<BoardVO> boardList = boardDao.boardList();
		/***Then***/
		assertEquals(3, boardList.size());
	}
	/**
	* Method : getBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 게시판 선택조회 테스트
	*/
	@Test
	public void getBoardTest() {
		/***Given***/
		/***When***/
		BoardVO boardVo = boardDao.getBoard(1);
		/***Then***/
		assertNotNull(boardVo);
		assertEquals("brown", boardVo.getUserId());
	}
	/**
	* Method : updateBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용여부 수정 테스트
	*/
	@Test
	public void updateBoardTest() {
		/***Given***/
		/***When***/
		BoardVO boardVo = new BoardVO(); 
		boardVo.setId(1);
		boardVo.setUse_yn("false");
		int result = boardDao.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, result);
	}
	/**
	* Method : boardAllList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용여부 상관없이 모든 boardList 조회 테스트
	*/
	@Test
	public void boardAllListTest() {
		/***Given***/
		/***When***/
		List<BoardVO> boardList = boardDao.boardAllList();
		/***Then***/
		assertEquals(3, boardList.size());
	}

}
