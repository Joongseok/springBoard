package kr.or.ddit.notice.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.testenv.LogicTestEnv;

public class NoticeServiceTest extends LogicTestEnv{

	@Resource(name = "noticeService")
	private INoticeService noticeService;
	
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
		pageMap.put("selected", "title");
		pageMap.put("search", "");
		Map<String, Object> resultMap =  noticeService.noticePagingList(pageMap);
		
		int paginationSize = (int) resultMap.get("paginationSize");
		List<NoticeVO> noticeList = (List<NoticeVO>) resultMap.get("noticeList");
		/***Then***/
		assertEquals(10, noticeList.size());
		assertEquals(2, paginationSize);
	}
	
//	/**
//	 * Method : noticeSearchPagingListTest
//	 * 작성자 : PC25
//	 * 변경이력 :
//	 * @return
//	 * Method 설명 : 게시글 검색 페이징 처리 테스트
//	 */
//	@Test
//	public void noticeSearchPagingListTest() {
//		/***Given***/
//		Map<String, Object> searchMap = new HashMap<String, Object>();
//		/***When***/
//		searchMap.put("id", 1);
//		searchMap.put("page", 1);
//		searchMap.put("pageSize", 10);
//		searchMap.put("selected", "title");
//		searchMap.put("search", 1);
//		Map<String, Object> resultMap =  noticeService.noticeSearchPagingList(searchMap);
//	
//		int paginationSize = (int) resultMap.get("paginationSize");
//		List<NoticeVO> noticeList = (List<NoticeVO>) resultMap.get("noticeList");
//		
//		/***Then***/
//		assertEquals(10, noticeList.size());
//		assertEquals(2, paginationSize);
//	}
	
//	/**
//	* Method : noticeCnt
//	* 작성자 : PC25
//	* 변경이력 :
//	* @param boardVo
//	* @return
//	* Method 설명 : 게시판의 번호에 해당하는 게시글을 출력하는 메서드 테스트
//	*/
//	@Test
//	public void noticeCntTest() {
//		/***Given***/
//		/***When***/
//		int noticeCnt = noticeService.noticeCnt(1);
//		/***Then***/
//		assertEquals(13, noticeCnt);
//	}
	
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
		int result = noticeService.insertNotice(noticeVo);
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
		int noticeAllCnt = noticeService.noticeAllCnt();
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
		Map<String, Object> resultMap = noticeService.getNotice(1);
		NoticeVO noticeVo = (NoticeVO) resultMap.get("noticeVo");
		List<Noti_commentVO> noti_commentList = (List<Noti_commentVO>) resultMap.get("ntcList"); 
		/***Then***/
		assertNotNull(noticeVo);
		assertEquals("brown", noticeVo.getUserId());
		assertEquals(1, noti_commentList.size());
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
		int noticeMaxId = noticeService.noticeMaxId();
		/***Then***/
		assertEquals(14, noticeMaxId);
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
		/***When***/
		NoticeVO noticeVo = new NoticeVO(1, "테스트 제목 수정", "테스트 내용 수정");
		int result = noticeService.updateNotice(noticeVo);
		/***Then***/
		assertEquals(1, result);
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
		/***When***/
		int result = noticeService.deleteNotice(1);
		/***Then***/
		assertEquals(1, result);
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
		/***When***/
		NoticeVO reply = new NoticeVO(14, "sally", "테스트 답글", "테스트 답글내용", 1, 1, 1);
		int result = noticeService.replyNotice(reply);
		/***Then***/
		assertEquals(1, result);
	}
	

}
