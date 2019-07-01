package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.notice.model.NoticeVO;
@Repository
public class NoticeDao implements INoticeDao {

	
	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(NoticeDao.class);
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시글 페이징 조회
	*/
	@Override
	public List<NoticeVO> noticePagingList(Map<String, Object>pageMap) {
		logger.debug("========================================Dao Start=============================================");
		logger.debug("Dao selected[" +pageMap.get("selected") +"]");
		logger.debug("Dao search[" +pageMap.get("search") +"]");
		logger.debug("Dao boardId[" +pageMap.get("id") +"]");
		logger.debug("Dao page[" +pageMap.get("page") +"]");
		logger.debug("Dao selectList[" +sqlSession.selectList("notice.noticePagingList", pageMap)+"]");
		logger.debug("Dao pageSize[" +pageMap.get("pageSize") +"]");
		logger.debug("========================================Dao End=============================================");
		return sqlSession.selectList("notice.noticePagingList", pageMap);
	}
//	/**
//	* Method : noticeCnt
//	* 작성자 : PC25
//	* 변경이력 :
//	* @param boardVo
//	* @return
//	* Method 설명 : 게시판의 번호에 해당하는 게시글을 출력하는 메서드
//	*/
//	@Override
//	public int noticeCnt(int id) {
//		return sqlSession.selectOne("notice.noticeCnt", id);
//	}
	/**
	* Method : insertNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 작성
	*/
	@Override
	public int insertNotice(NoticeVO noticeVo) {
		return sqlSession.insert("notice.insertNotice", noticeVo);
	}
	/**
	* Method : noticeAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판의 게시글을 합친수
	*/
	@Override
	public int noticeAllCnt() {
		return sqlSession.selectOne("notice.noticeAllCnt");
	}
	/**
	* Method : getNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 게시글 선택조회
	*/
	@Override
	public NoticeVO getNotice(int notiId) {
		return sqlSession.selectOne("notice.getNotice", notiId);
	}
	/**
	* Method : noticeMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글의 마지막 번호 +1
	*/
	@Override
	public int noticeMaxId() {
		return sqlSession.selectOne("notice.noticeMaxId");
	}
	/**
	* Method : updateNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updateNotice(NoticeVO noticeVo) {
		return sqlSession.update("notice.updateNotice", noticeVo);
	}
	/**
	* Method : deleteNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 삭제
	*/
	@Override
	public int deleteNotice(int notiId) {
		return sqlSession.delete("notice.deleteNotice", notiId);
	}
	
	/**
	* Method : replyNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param createNoticeVo
	* @return
	* Method 설명 : 답글
	*/
	@Override
	public int replyNotice(NoticeVO createNoticeVo) {
		return sqlSession.insert("notice.replyNotice", createNoticeVo);
	}
	/**
	* Method : noticeSearchPagingList
	* 작성자 : PC25
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 게시글 검색 페이징 처리
	*/
	@Override
	public List<NoticeVO> noticeSearchPagingList(Map<String, Object> searchMap) {
		return sqlSession.selectList("notice.noticeSearchPagingList", searchMap);
	}
	
	/**
	* Method : noticeSearchCnt
	* 작성자 : PC25
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 검색한  결과에 해당하는 게시글 의 수
	*/
	@Override
	public int noticeSearchCnt(Map<String, Object> searchMap) {
		return sqlSession.selectOne("notice.noticeSearchCnt", searchMap);
	}

}
