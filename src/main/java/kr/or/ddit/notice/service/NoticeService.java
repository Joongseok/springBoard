package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.noti_comment.dao.INoti_CommentDao;
import kr.or.ddit.noti_comment.model.Noti_commentVO;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.uploadFile.dao.IUploadFileDao;
import kr.or.ddit.uploadFile.model.UploadFileVO;
@Service
public class NoticeService implements INoticeService {
	
	@Resource(name = "noticeDao")
	private INoticeDao noticeDao;
	
	@Resource(name = "noti_commentDao")
	private INoti_CommentDao noti_commentDao;
	
	@Resource(name = "uploadFileDao")
	private IUploadFileDao uploadFileDao;
	
	
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 페이징 조회
	*/
	@Override
	public Map<String, Object> noticePagingList(Map<String, Object> pageMap) {
		int id = (int)pageMap.get("id");
		
		List<NoticeVO> noticeList = noticeDao.noticePagingList(pageMap);
		int noticeCnt = noticeDao.noticeCnt(id);
		
		int pageSize = (int) pageMap.get("pageSize");
		int paginationSize = (int) Math.ceil((double)noticeCnt/pageSize);
		if (paginationSize == 0) {
			paginationSize = 1;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeList", noticeList);
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	/**
	* Method : noticeCnt
	* 작성자 : PC25
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 해당 게시판의 게시글 수
	*/
	@Override
	public int noticeCnt(int id) {
		return noticeDao.noticeCnt(id);
	}
	
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
		return noticeDao.insertNotice(noticeVo);
	}
	/**
	* Method : noticeAllCnt
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 모든게시판의 게시글을 합친수
	*/
	@Override
	public int noticeAllCnt() {
		return noticeDao.noticeAllCnt();
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
	public Map<String, Object> getNotice(int notiId) {
		NoticeVO noticeVo = noticeDao.getNotice(notiId);
		List<UploadFileVO> uploadFileList =  uploadFileDao.getUploadFileList(notiId);
		List<Noti_commentVO> ntcList = noti_commentDao.commentList(notiId);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeVo", noticeVo);
		resultMap.put("uploadFileList", uploadFileList);
		resultMap.put("ntcList", ntcList);
		
		
		return resultMap;
	}
	/**
	* Method : noticeMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글의 가장 마지막 번호
	*/
	@Override
	public int noticeMaxId() {
		return noticeDao.noticeMaxId();
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
		return noticeDao.updateNotice(noticeVo);
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
		return noticeDao.deleteNotice(notiId);
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
		return noticeDao.replyNotice(createNoticeVo);
	}

}
