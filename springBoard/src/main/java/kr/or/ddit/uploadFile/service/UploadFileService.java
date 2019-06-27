package kr.or.ddit.uploadFile.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.uploadFile.dao.IUploadFileDao;
import kr.or.ddit.uploadFile.model.UploadFileVO;

@Service
public class UploadFileService implements IUploadFileService{

	@Resource(name = "uploadFileDao")
	private IUploadFileDao uploadFileDao;
	
	/**
	* Method : insertUploadFile
	* 작성자 : PC25
	* 변경이력 :
	* @param uploadFile
	* Method 설명 : 첨부파일을 등록하는 메서드
	*/
	@Override
	public int insertUploadFile(List<UploadFileVO> uploadFileList) {
		int insertCntSum = 0;
		for(UploadFileVO uploadFile : uploadFileList){
			int insertCnt = uploadFileDao.insertUploadFile( uploadFile);
			
			insertCntSum += insertCnt;
			
		}
		return insertCntSum;
	}

	/**
	* Method : getUploadFile
	* 작성자 : PC25
	* 변경이력 :
	* @param notiId
	* @return
	* Method 설명 : 해당 게시글의 첨부파일을 불러오는 메서드
	*/
	@Override
	public List<UploadFileVO> getUploadFileList(int notiId) {
		return uploadFileDao.getUploadFileList(notiId);
	}

	/**
	* Method : getFileVo
	* 작성자 : PC25
	* 변경이력 :
	* @param fileId
	* @return
	* Method 설명 : 아이디에 해당하는 파일 vo가져오기
	*/
	@Override
	public UploadFileVO getFileVo(String fileId) {
		return uploadFileDao.getFileVo(fileId);
	}
	/**
	* Method : dbDeleteFile
	* 작성자 : PC25
	* 변경이력 :
	* @param uploadFileList
	* @return
	* Method 설명 : 게시글 수정할때 DB에 있는 그전의 첨부파일 내역을 삭제한다.(실제 폴더에서 삭제되지는 않음)
	*/
	@Override
	public int dbDeleteFile(List<UploadFileVO> uploadFileList) {
		
		int deleteCntSum = 0;
		for(UploadFileVO uploadFile : uploadFileList){
			int deleteCnt = uploadFileDao.dbDeleteFile(uploadFile);
			
			deleteCntSum += deleteCnt;
			
		}
		return deleteCntSum;
	}

}
