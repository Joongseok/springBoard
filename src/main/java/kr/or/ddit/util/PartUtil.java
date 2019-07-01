package kr.or.ddit.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.uploadFile.model.UploadFileVO;

public class PartUtil {
	private static final String UPLOAD_PATH = "d:"+ File.separator +"springupload"+ File.separator;
	
	/**
	* Method : getExtTest
	* 작성자 : PC25
	* 변경이력 :
	* Method 설명 : 파일이름에서 확장자를 가져오는 메서드
	*/
	public static String getExt(String fileName) {
		String ext = "";
		if (fileName.contains(".")) {
			int extIndex = fileName.lastIndexOf(".");
			ext = fileName.substring(extIndex);
		}
		return ext;
	}
	/**
	* Method : setMkdir
	* 작성자 : PC25
	* 변경이력 :
	* @return
	* Method 설명 : 해당하는 폴더가 없으면 생성해주는 메서드
	*/
	public static Map<String, Object> setMkdir() {
		//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지
		Date dt = new Date();
		SimpleDateFormat yyyyMMSdf = new SimpleDateFormat("yyyyMM");
		
		String yyyyMM = yyyyMMSdf.format(dt);
		
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		String sp = File.separator;
		
		File yyyyFolder = new File(UPLOAD_PATH + yyyy);
		// 신규년도로 넘어갔을때 해당 년도의 폴더를 생성한다.
		if(!yyyyFolder.exists()){
			yyyyFolder.mkdir();
		}
		
		//월에 해당하는 폴더가 있는지 확인
		File mmFolder = new File(UPLOAD_PATH + yyyy + sp + mm);
		if(!mmFolder.exists()){
			mmFolder.mkdir();
		}
		
		String uploadPath = UPLOAD_PATH + yyyy + sp + mm;
		File uploadFolder = new File(uploadPath);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("uploadPath", uploadPath);
		resultMap.put("uploadFolder", uploadFolder);
		return resultMap;
	}
	
	/**
	* Method : getUploadFileList
	* 작성자 : OWNER
	* 변경이력 :
	* @param files
	* @param notiId
	* @return
	* Method 설명 : multipartfile 배열을 매개로 받아서 단일/ 다중업로드 파일을 처리하는 메서드
	*/
	public static List<UploadFileVO> getUploadFileList(MultipartFile[] files, int notiId){
		List<UploadFileVO> uploadFileList = new ArrayList<UploadFileVO>();
		for (MultipartFile file : files) {
			String fileName =  file.getOriginalFilename();
			 String ext = PartUtil.getExt(fileName); 
			 String sp = File.separator;
			 Map<String, Object> resultMap = PartUtil.setMkdir(); 
			 String uploadPath = (String)resultMap.get("uploadPath");
			 String filePath = uploadPath + sp + UUID.randomUUID().toString() + ext; 
			 String fileId = filePath;
			 File uploadfile = new File(filePath);
			 try {
				 file.transferTo(uploadfile);
			 } catch (IllegalStateException | IOException e) {
				 e.printStackTrace();
			 }
			 UploadFileVO uploadFile = new UploadFileVO(fileId, notiId, uploadPath, fileName);
			uploadFileList.add(uploadFile);
		}
		return uploadFileList;
	}
		
}
