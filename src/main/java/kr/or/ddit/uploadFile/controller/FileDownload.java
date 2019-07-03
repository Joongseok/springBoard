package kr.or.ddit.uploadFile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.uploadFile.model.UploadFileVO;
import kr.or.ddit.uploadFile.service.IUploadFileService;


public class FileDownload extends AbstractView {
   
	@Resource(name = "uploadFileService")
	private IUploadFileService fileService;
	
	/**
	* Method : renderMergedOutputModel
	* 작성자 : PC25
	* 변경이력 :
	* @param model
	* @param request
	* @param response
	* @throws Exception
	* Method 설명 : 
	* 				사용자가 NoticeDetail.jsp에서 첨부 파일 다운로드를 클릭했을때
	* 				noticeController에 매핑된 path로 요청이 가고
	* 				application-context.xml 에서 설정한 BeanNameViewResolver를 통해
	* 				해당 요청을 받은 컨트롤러는 application-context에 미리 만들어져있는 bean아이디를 리턴 
	* 				Bean아이디와 매칭되는 해당 클래스로 이동한다.
	*/
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			// 컨트롤러에서 담아온 다운로드 할 fileId
			String fileId = (String) model.get("fileId");
			
			// 파일 아이디에 해당하는 파일 정보를 담은 객체
			UploadFileVO fileVo = fileService.getFileVo(fileId);
			
			// 파일 이름
			String fileName = fileVo.getFileName();
			
			// 다운로드할 첨부파일 이름 설정
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			response.setContentType("application/octet-stream");
			
			// 서버에 저장된 파일 경로
			File file = new File(fileId);
			
			// 서버에 저장된 파일을 읽는다.
			FileInputStream fis = new FileInputStream(file);
			
			// 사용자에게 응답 할 OutputStream
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buff = new byte[1024];
			int len = -1;
			
			while( (len = fis.read(buff)) != -1 ){
				sos.write(buff); // 응답
			}
			
			sos.close();
			fis.close();
	}
}
