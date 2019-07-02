package kr.or.ddit.notice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.noti_comment.dao.INoti_CommentDao;
import kr.or.ddit.noti_comment.service.INoti_CommentService;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.uploadFile.dao.IUploadFileDao;
import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;
import kr.or.ddit.util.PartUtil;
@Service
public class NoticeService implements INoticeService {
	
	@Resource(name = "noticeDao")
	private INoticeDao noticeDao;
	
	@Resource(name = "noti_commentDao")
	private INoti_CommentDao noti_commentDao;
	
	@Resource(name = "noti_CommentService")
	private INoti_CommentService noti_commentService;
	
	@Resource(name = "uploadFileDao")
	private IUploadFileDao uploadFileDao;
	
	@Resource(name = "uploadFileService")
	private IUploadFileService uploadFileService;
	
	@Resource(name =  "boardService")
	private IBoardService boardService;
	
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @param pageMap
	* @return
	* Method 설명 : 검색 기능을 포함한 계층형 게시글 페이징 리스트
	*/
	@Override
	public Map<String, Object> noticePagingList(Map<String, Object> pageMap) {
		
		// 검색한 내용에 해당하는 게시글이 페이징 처리 되어 리스트에 담긴다
		List<NoticeVO> noticeList = noticeDao.noticePagingList(pageMap);
		
		// 검색한 내용에 해당하는 전체 게시글의 수
		int noticeCnt = noticeDao.noticeSearchCnt(pageMap);
		
		// 컨트롤러에서 담아온 pageSize
		int pageSize = (int) pageMap.get("pageSize");
		int paginationSize = (int) Math.ceil((double)noticeCnt/pageSize);
		
		// 게시글이 없어서 paginationSize가 0 일경우 임의로 1설정
		paginationSize = paginationSize == 0 ? 1 : paginationSize;
		
		// Map객체에 페이징 처리된 게시글 리스트와 페이지의 갯수를 담아서 리턴한다
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeList", noticeList);
		resultMap.put("paginationSize", paginationSize);
		resultMap.put("boardVo", boardService.getBoard((int)pageMap.get("id")));
		
		return resultMap;
	}
	
	/**
	* Method : noticeMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글의 가장 마지막 번호 +1
	*/
	@Override
	public int noticeMaxId() {
		return noticeDao.noticeMaxId();
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
	* Method : insertNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시글 작성
	*/
	@Override
	public int insertNotice(NoticeVO noticeVo, MultipartFile[] files) {
		
		// 게시글 작성
		int result = noticeDao.insertNotice(noticeVo);
		
		// 작성한 게시글에 첨부파일이 있으면 수행
		if(files != null && files.length > 0) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, noticeVo.getNotiId());
			
			if(uploadFileList != null) 
				uploadFileService.insertUploadFile(uploadFileList);
		}
		return result;
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
	public int replyNotice(NoticeVO createNoticeVo, MultipartFile[] files) {
		
		// 답글 작성
		int result = noticeDao.replyNotice(createNoticeVo);
		
		// 작성한 답글에 첨부파일이 있으면 수행
		if(files != null && files.length > 0) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, createNoticeVo.getNotiId());
			
			if(uploadFileList != null) 
				uploadFileService.insertUploadFile(uploadFileList);
		}
		return result;
	}
	
	/**
	* Method : getNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 아이디에 해당하는 게시글 정보
	*/
	@Override
	public Map<String, Object> getNotice(int notiId) {
		
		// Map 객체에 게시글 아이디에 해당하는 게시글의 내용/ 파일/ 댓글을 담는다.
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("noticeVo", noticeDao.getNotice(notiId));
		resultMap.put("uploadFileList", uploadFileDao.getUploadFileList(notiId));
		resultMap.put("ntcList", noti_commentDao.commentList(notiId));
		
		return resultMap;
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
	public int updateNotice(NoticeVO noticeVo, String[] deleteFileId, MultipartFile[] files) {
		int result = noticeDao.updateNotice(noticeVo);
		
		// 게시글 수정에서 기존에 있던 첨부파일을 삭제 했을때 삭제한 파일을 담을 리스트
		List<UploadFileVO> dbUploadFileList = new ArrayList<UploadFileVO>();
		
		// 삭제할 파일이 존재하면 수행
		if(deleteFileId != null && deleteFileId.length > 0) { 
			for(String fileid : deleteFileId)
				if (fileid !=null) 
					dbUploadFileList.add(uploadFileService.getFileVo(fileid));
			
			if (dbUploadFileList.size() != 0) 
				uploadFileService.dbDeleteFile(dbUploadFileList);
		}
		
		// 게시글 수정에서 새로운 첨부파일을 등록했을때 수행
		if(files != null) {
			List<UploadFileVO> uploadFileList = PartUtil.getUploadFileList(files, noticeVo.getNotiId());
			
			if(uploadFileList != null)
				uploadFileService.insertUploadFile(uploadFileList);
		}
		return result;
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
		
		// 게시글에 있는 댓글 삭제
		noti_commentService.deleteComment(noti_commentService.commentList(notiId));
		
		// 게시글 삭제
		return noticeDao.deleteNotice(notiId);
	}
	

}
