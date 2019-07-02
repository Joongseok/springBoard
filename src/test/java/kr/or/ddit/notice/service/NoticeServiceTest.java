package kr.or.ddit.notice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	* Method : insertNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 작성 테스트
	 * @throws IOException 
	 * @throws FileNotFoundException 
	*/
	@Test
	public void insertNoticeTest() throws FileNotFoundException, IOException {
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MultipartFile[] files = {new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f))};
		NoticeVO noticeVo = new NoticeVO(14, "brown", "테스트 제목 14", "테스트 내용 14", 1, 14);
		/***When***/
		int result = noticeService.insertNotice(noticeVo, files);
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
	* Method 설명 : 게시글 선택조회 테스트
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
	* Method 설명 : 게시글의 마지막 번호 테스트
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
	* Method 설명 : 게시글 수정 테스트
	 * @throws IOException 
	 * @throws FileNotFoundException 
	*/
	@Test
	public void updateNoticeTest() throws FileNotFoundException, IOException {
		/***Given***/
		/***When***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MultipartFile[] files = {new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f))};
		String[] deleteId = new String[] {};
		NoticeVO noticeVo = new NoticeVO(1, "테스트 제목 수정", "테스트 내용 수정");
		int result = noticeService.updateNotice(noticeVo,deleteId, files);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	* Method : deleteNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 삭제 테스트
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
	* Method 설명 : 답글 테스트
	 * @throws IOException 
	 * @throws FileNotFoundException 
	*/
	@Test
	public void replyNoticeTest() throws FileNotFoundException, IOException {
		/***Given***/
		/***When***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MultipartFile[] files = {new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f))};
		NoticeVO reply = new NoticeVO(14, "sally", "테스트 답글", "테스트 답글내용", 1, 1, 1);
		int result = noticeService.replyNotice(reply, files);
		/***Then***/
		assertEquals(1, result);
	}
	

}
