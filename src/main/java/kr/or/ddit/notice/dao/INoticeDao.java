package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeVO;

public interface INoticeDao {
	
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @param pageMap
	* @return
	* Method 설명 : 검색 기능을 포함한 계층형 게시글 페이징 리스트
	*/
	List<NoticeVO> noticePagingList(Map<String, Object>pageMap);
	
	/**
	 * Method : noticeMaxId
	 * 작성자 : PC25
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글의 가장 마지막 번호  +1
	 */
	int noticeMaxId();
	
	/**
	* Method : noticeSearchCnt
	* 작성자 : PC25
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 검색한  결과에 해당하는 게시글 의 수
	*/
	int noticeSearchCnt(Map<String, Object> searchMap);
	
	/**
	 * Method : noticeAllCnt
	 * 작성자 : PC25
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든게시판의 게시글을 합친수
	 */
	int noticeAllCnt();
	
	/**
	* Method : insertNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 작성
	*/
	int insertNotice(NoticeVO noticeVo);

	/**
	* Method : replyNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param createNoticeVo
	* @return
	* Method 설명 : 답글
	*/
	int replyNotice(NoticeVO createNoticeVo);

	/**
	* Method : getNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 아이디에 해당하는 게시글 정보
	*/
	NoticeVO getNotice(int notiId);

	/**
	* Method : updateNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updateNotice(NoticeVO noticeVo);

	/**
	* Method : deleteNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 게시글 삭제
	*/
	int deleteNotice(int notiId);

}
