package kr.or.ddit.notice.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.testenv.LogicTestEnv;

public class NoticeDaoTest extends LogicTestEnv{

	@Resource(name = "noticeDao")
	private INoticeDao noticeDao;
	
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판에 해당하는 게시글만 조회 테스트
	*/
	@Test
	public void noticePagingListTest() {
		/***Given***/
		Map<String, Object> pageMap = new HashMap<String, Object>();
		/***When***/
		pageMap.put("id", 1);
		pageMap.put("page", 1);
		pageMap.put("pageSize", 10);
		List<NoticeVO> noticeList =  noticeDao.noticePagingList(pageMap);
		/***Then***/
		assertEquals(10, noticeList.size());
	}
	
	/**
	* Method : noticeCnt
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판의 번호에 해당하는 게시글을 출력하는 메서드 테스트
	*/
	@Test
	public void noticeCntTest() {
		/***Given***/
		/***When***/
		int noticeCnt = noticeDao.noticeCnt(1);
		/***Then***/
		assertEquals(13, noticeCnt);
	}
	
	/**
	* Method : insertNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 작성 테스트
	*/
	@Test
	public void insertNoticeTest() {
		/***Given***/
		/***When***/
		NoticeVO noticeVo = new NoticeVO(14, "brown", "테스트 제목 14", "테스트 내용 14", 1, 14);
		int result = noticeDao.insertNotice(noticeVo);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	* Method : noticeAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판의 게시글을 합친수 테스트
	*/
	@Test
	public void noticeAllCntTest() {
		/***Given***/
		/***When***/
		int noticeAllCnt = noticeDao.noticeAllCnt();
		/***Then***/
		assertEquals(13, noticeAllCnt);
	}
	
	/**
	* Method : getNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 게시글 선택조회
	*/
	@Test
	public void getNoticeTest() {
		/***Given***/
		/***When***/
		NoticeVO noticeVo = noticeDao.getNotice(1);
		/***Then***/
		assertNotNull(noticeVo);
		assertEquals("brown", noticeVo.getUserId());
	}
	
	/**
	* Method : noticeMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글의 마지막 번호
	*/
	@Test
	public void noticeMaxIdTest() {
		/***Given***/
		/***When***/
		int noticeMaxId = noticeDao.noticeMaxId();
		/***Then***/
		assertEquals(13, noticeMaxId);
	}
	
	/**
	* Method : updateNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Test
	public void updateNoticeTest() {
		/***Given***/
		Map<String, Object> pageMap = new HashMap<String, Object>();
		/***When***/
		pageMap.put("id", 1);
		pageMap.put("page", 1);
		pageMap.put("pageSize", 10);
		List<NoticeVO> noticeList =  noticeDao.noticePagingList(pageMap);
		/***Then***/
		assertEquals(10, noticeList.size());
	}
	
	/**
	* Method : deleteNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 삭제
	*/
	@Test
	public void deleteNoticeTest() {
		/***Given***/
		Map<String, Object> pageMap = new HashMap<String, Object>();
		/***When***/
		pageMap.put("id", 1);
		pageMap.put("page", 1);
		pageMap.put("pageSize", 10);
		List<NoticeVO> noticeList =  noticeDao.noticePagingList(pageMap);
		/***Then***/
		assertEquals(10, noticeList.size());
	}
	
	/**
	* Method : replyNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param createNoticeVo
	* @return
	* Method 설명 : 답글
	*/
	@Test
	public void replyNoticeTest() {
		/***Given***/
		Map<String, Object> pageMap = new HashMap<String, Object>();
		/***When***/
		pageMap.put("id", 1);
		pageMap.put("page", 1);
		pageMap.put("pageSize", 10);
		List<NoticeVO> noticeList =  noticeDao.noticePagingList(pageMap);
		/***Then***/
		assertEquals(10, noticeList.size());
	}
	

}
