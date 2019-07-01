package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVO;

@Repository
public class BoardDao implements IBoardDao {

	// application-dataSource에서 빈으로 등록한 sqlSessionTemplate을 사용 
	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	
	/**
	* Method : boardsCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 수  +1
	*/
	@Override
	public int boardCnt() {
		return sqlSession.selectOne("board.boardCnt");
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
		return sqlSession.selectList("board.boardList");
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
		return sqlSession.selectList("board.boardAllList");
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
		return  sqlSession.selectOne("board.getBoard", id);
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
		return sqlSession.insert("board.insertBoard", boardVo);
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
		return sqlSession.delete("board.updateBoard", boardVo);
	}
}
