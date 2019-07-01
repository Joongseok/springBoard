package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface IBoardDao {
	
	/**
	* Method : boardsCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 수 +1
	*/
	int boardCnt();

	/**
	* Method : boardList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용중인 게시판 조회
	*/
	List<BoardVO> boardList();
	
	/**
	* Method : boardAllList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 사용 여부와 관계없이 모든 게시판 조회
	*/
	List<BoardVO> boardAllList();
	
	/**
	 * Method : getBoard
	 * 작성자 : PC25
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 게시판 아이디에 해당하는 게시판 정보
	 */
	BoardVO getBoard(int id);
	
	/**
	 * Method : insertBoard
	 * 작성자 : PC25
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 등록
	 */
	int insertBoard(BoardVO boardVo);
	
	
	/**
	* Method : updateBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용여부 수정
	*/
	int updateBoard(BoardVO boardVo);
	
}
