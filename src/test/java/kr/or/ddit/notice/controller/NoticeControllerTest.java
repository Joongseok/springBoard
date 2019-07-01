package kr.or.ddit.notice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;
import kr.or.ddit.user.model.UserVO;

public class NoticeControllerTest extends ControllerTestEnv{

	@Resource(name = "noticeService")
	private INoticeService noticeService;
	
	@Resource(name = "noti_CommentService")
	private INoti_CommentService ntcService;
	
	@Resource(name = "uploadFileService")
	private IUploadFileService uploadFileService;
	
	@Resource(name =  "boardService")
	private IBoardService boardService;
	
	/**
	* Method : noticeController
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @param pageVo
	* @param model
	* @return
	* Method 설명 : 게시글 페이징 리스트 테스트
	 * @throws Exception 
	*/
	@Test
	public void noticeControllerTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/noticeController")
									.param("id", "1")
									.requestAttr("pageVo", new PageVO())
									.param("pageSize", "0")
									.param("search", "1")
									.param("selected", "title")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		Map<String, Object> pageMap = (Map<String, Object>) mav.getModelMap().get("pageMap");
		List<NoticeVO> noticeList = (List<NoticeVO>) mav.getModelMap().get("noticeList");
		int paginationSize = (int) mav.getModelMap().get("paginationSize"); 
		BoardVO boardVo = (BoardVO) mav.getModelMap().get("boardVo");
		
		int id = (int)pageMap.get("id");
		int page = (int) pageMap.get("page");
		int pageSize = (int) pageMap.get("pageSize");
		/***Then***/
		assertEquals(id, 1);
		assertEquals(page, 1);
		assertEquals(pageSize, 10);
		assertEquals(1, paginationSize);
		assertEquals(5, noticeList.size());
		assertEquals("자유 게시판", boardVo.getName());
	}
	
	
	
	/**
	* Method : NoticeDetail
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param request
	* @return
	* Method 설명 : 게시글 상세 조회 테스트
	 * @throws Exception 
	*/
	@Test
	public void NoticeDetailTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/noticeDetail")
									.param("notiId", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		Map<String, Object> noticeDetailMap = (Map<String, Object>) mav.getModelMap().get("notiDeatilMap");
		NoticeVO noticeVo = (NoticeVO) noticeDetailMap.get("noticeVo");
		List<Noti_commentVO> ntcList = (List<Noti_commentVO>) noticeDetailMap.get("ntcList");
		/***Then***/
		assertEquals("brown", noticeVo.getUserId());
		assertEquals(1, ntcList.size());
		assertEquals("tiles.noticeDetail", viewName);
	}
	
	/**
	* Method : NoticeFormGet
	* 작성자 : OWNER
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 등록 요청화면
	 * @throws Exception 
	*/
	@Test
	public void NoticeFormGetTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/noticeForm")
									.param("id", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("tiles.noticeForm", viewName);
	}
	/**
	 * Method : NoticeFormGet
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 등록 응답화면
	 * @throws Exception 
	 */
	@Test
	public void NoticeFormPostTest() throws Exception {
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile files = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		
		/***When***/
		UserVO userVo = new UserVO();
		userVo.setUserId("brown");
		MvcResult mvcResult = mockMvc.perform(fileUpload("/notice/noticeForm").file(files)
									.param("id", "1")
									.param("title", "테스트 제목")
									.param("smarteditor", "테스트내용")
									.sessionAttr("USER_INFO", userVo)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();

		// redirect.addAttribute에 들어간 객체는 String으로 반환된다???
		String notiId =(String) mav.getModelMap().get("notiId");
		/***Then***/
		assertEquals("14", notiId);
		assertEquals("redirect:/notice/noticeDetail", viewName);
	}
	
	/**
	* Method : deleteNotice
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param redirectAttributes
	* @return
	* Method 설명 : 게시글 삭제
	 * @throws Exception 
	*/
	@Test
	public void deleteNoticeTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/deleteNotice")
									.param("notiId", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		String id = (String) mav.getModelMap().get("id");
		/***Then***/
		assertEquals("redirect:/notice/noticeController", viewName);
		assertEquals("1", id);
	}
	
	/**
	* Method : replyNoticeGet
	* 작성자 : OWNER
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 답글 요청 화면
	 * @throws Exception 
	*/
	@Test
	public void replyNoticeGetTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/replyNotice")
									.param("notiId", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		int notiId = (int) mav.getModelMap().get("notiId");
		/***Then***/
		assertEquals("tiles.replyNotice", viewName);
		assertEquals(1, notiId);
	}
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeControllerTest.class);
	/**
	 * Method : replyNoticeGet
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 답글 응답 화면
	 * @throws Exception 
	 */
	@Test
	public void replyNoticePostTest() throws Exception {
		/***Given***/
		/***When***/
		UserVO userVo = new UserVO();
		userVo.setUserId("brown");
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile files = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		
		MvcResult mvcResult = mockMvc.perform(fileUpload("/notice/replyNotice")
										.file(files).file(files).file(files)
										.param("title", "테스트 답글 제목")
										.param("notiId", "1")
										.param("smarteditor", "테스트 답글 내용")
										.sessionAttr("USER_INFO", userVo)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		String notiId = (String) mav.getModelMap().get("notiId");
		logger.debug("notiid : {}", notiId);
		/***Then***/
		assertEquals("redirect:/notice/noticeDetail", viewName);
		assertEquals("14", notiId);
	}
	
	/**
	* Method : updateNotice
	* 작성자 : OWNER
	* 변경이력 :
	* @param notiId
	* @param model
	* @return
	* Method 설명 : 사용자 수정 요청화면
	 * @throws Exception 
	*/
	@Test
	public void updateNoticeTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/notice/updateNotice")
										.param("notiId", "1")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		NoticeVO noticeVo = (NoticeVO) mav.getModelMap().get("noticeVo");
		List<UploadFileVO> fileLsit = (List<UploadFileVO>) mav.getModelMap().get("fileList");
		/***Then***/
		assertEquals("brown", noticeVo.getUserId());
		assertEquals("tiles.updateNotice", viewName);
		assertEquals(0, fileLsit.size());
	}
	
	/**
	 * Method : updateNotice
	 * 작성자 : OWNER
	 * 변경이력 :
	 * @param notiId
	 * @param model
	 * @return
	 * Method 설명 : 사용자 수정 응답화면
	 * @throws Exception 
	 */
	@Test
	public void updateNoticePostTest() throws Exception {
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile files = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		/***When***/
		MvcResult mvcResult = mockMvc.perform(fileUpload("/notice/updateNotice").file(files).file(files)
				.param("title", "테스트 수정 제목")
				.param("notiId", "1")
				.param("smarteditor", "테스트 수정 내용")
				).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		String notiId = (String) mav.getModelMap().get("notiId");
		/***Then***/
		assertEquals("redirect:/notice/noticeDetail", viewName);
		assertEquals("1", notiId);
	}

}
