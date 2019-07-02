package kr.or.ddit.noti_comment.dao;

import java.util.List;

import kr.or.ddit.noti_comment.model.Noti_commentVO;

public interface INoti_CommentDao {

	/**
	* Method : commentAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 전체 댓글 수
	*/
	int commentAllCnt();

	/**
	* Method : commentMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 댓글의 마지막 번호 + 1
	*/
	int commentMaxId();

	/**
	* Method : commentList
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 해당게시글의 댓글 리스트
	*/
	List<Noti_commentVO> commentList(int notiId);
	
	/**
	 * Method : isertComment
	 * 작성자 : PC25
	 * 변경이력 :
	 * @param ntcVo
	 * @return
	 * Method 설명 : 댓글 작성
	 */
	int insertComment(Noti_commentVO ntcVo);

	/**
	* Method : deleteComment
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 해당 게시글 이 삭제되면 댓글도 전부 cascade
	*/
	int deleteComment(int id);

	/**
	* Method : deleteCmt
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 해당 ID의 댓글 삭제
	*/
	int deleteCmt(int ntcId);

}
