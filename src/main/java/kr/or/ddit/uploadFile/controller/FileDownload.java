package kr.or.ddit.uploadFile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;


public class FileDownload extends AbstractView {
   
	@Resource(name = "uploadFileService")
	private IUploadFileService fileService;
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownload.class);
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
			String fileId = (String) model.get("fileId");
			logger.debug("fileDown ~~~ : {}", fileId);
			// 아이디에 맞는 정보를 담은 첨부파일 객체
			UploadFileVO fileVo = fileService.getFileVo(fileId);
			
			// 첨부파일 이름
			String fileName = fileVo.getFileName();
			
			
			// 다운로드할 첨부파일 이름 설정
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			response.setContentType("application/octet-stream");
			
			// 파일 객체 생성
			File file = new File(fileId);
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buff = new byte[1024];
			int len = -1;
			
			while( (len = fis.read(buff)) != -1 ){
				sos.write(buff);
			}
			
			sos.close();
			fis.close();
	}
}
