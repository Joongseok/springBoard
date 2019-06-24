package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVO;

@Repository
public class BoardDao implements IBoardDao {

	
	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	/**
	* Method : boardsCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 수 조회
	*/
	@Override
	public int boardsCnt() {
		int boardsCnt = sqlSession.selectOne("board.boardsCnt");
		return boardsCnt;
	}

	/**
	* Method : insertBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	@Override
	public int insertBoard(BoardVO boardVo) {
		int insertBoard = sqlSession.insert("board.insertBoard", boardVo);
		return insertBoard;
	}

	/**
	* Method : boardList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용여부가 true인 boardList 조회
	*/
	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> boardList = sqlSession.selectList("board.boardList");
		return boardList;
	}

	/**
	* Method : getBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 게시판 선택조회
	*/
	@Override
	public BoardVO getBoard(int id) {
		BoardVO boardVo = sqlSession.selectOne("board.getBoard", id);
		return boardVo;
	}

	/**
	* Method : updateBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용여부 수정
	*/
	@Override
	public int updateBoard(BoardVO boardVo) {
		int updateBoard = sqlSession.delete("board.updateBoard", boardVo);
		return updateBoard;
	}

	/**
	* Method : boardAllList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용여부 상관없이 모든 boardList 조회
	*/
	@Override
	public List<BoardVO> boardAllList() {
		List<BoardVO> boardList = sqlSession.selectList("board.boardAllList");
		return boardList;
	}
}
