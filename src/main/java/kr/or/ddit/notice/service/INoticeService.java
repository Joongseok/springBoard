package kr.or.ddit.notice.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.notice.model.NoticeVO;

public interface INoticeService {
	
	/**
	* Method : noticeList
	* 작성자 : PC25
	* 변경이력 :
	* @param pageMap
	* @return
	* Method 설명 : 검색 기능을 포함한 계층형 게시글 페이징 리스트
	*/
	Map<String, Object> noticePagingList(Map<String, Object> pageMap);
	
	/**
	* Method : noticeMaxId
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 게시글의 가장 마지막 번호 +1
	*/
	int noticeMaxId();
	
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
	* @param files
	* @return
	* Method 설명 : 게시글 작성
	*/
	int insertNotice(NoticeVO noticeVo, MultipartFile[] files);

	/**
	* Method : replyNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param createNoticeVo
	* @param files
	* @return
	* Method 설명 : 답글
	*/
	int replyNotice(NoticeVO createNoticeVo, MultipartFile[] files);
	
	/**
	* Method : getNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 아이디에 해당하는 게시글 정보
	*/
	Map<String, Object> getNotice(int notiId);

	/**
	* Method : updateNotice
	* 작성자 : PC25
	* 변경이력 :
	* @param noticeVo
	* @param deleteFileId
	* @param files
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updateNotice(NoticeVO noticeVo, String[] deleteFileId, MultipartFile[] files);

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
