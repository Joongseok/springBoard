package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVO;

@Service
public class BoardService implements IBoardService {

	// @Repository로 등록한 boardDao를 사용
	@Resource(name = "boardDao")
	private IBoardDao boardDao;
	
	/**
	* Method : boardsCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 수 +1
	*/
	@Override
	public int boardCnt() {
		return boardDao.boardCnt();
	}

	/**
	* Method : getBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 게시판 아이디에 해당하는 게시판 정보
	*/
	@Override
	public BoardVO getBoard(int id) {
		return boardDao.getBoard(id);
	}
	
	/**
	* Method : boardList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용중인 게시판 조회
	*/
	@Override
	public List<BoardVO> boardList() {
		return boardDao.boardList();
	}
	
	/**
	 * Method : boardAllList
	 * 작성자 : PC25
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용 여부와 관계없이 모든 게시판 조회
	 */
	@Override
	public List<BoardVO> boardAllList() {
		return boardDao.boardAllList();
	}
	
	/**
	* Method : insertBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	@Override
	public int insertBoard(BoardVO boardVo) {
		
		return boardDao.insertBoard(boardVo);
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
		return boardDao.updateBoard(boardVo);
	}
	
}
