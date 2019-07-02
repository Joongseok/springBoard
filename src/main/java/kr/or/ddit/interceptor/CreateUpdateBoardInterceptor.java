package kr.or.ddit.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.board.service.IBoardService;

public class CreateUpdateBoardInterceptor extends HandlerInterceptorAdapter{

	@Resource(name = "boardService")
	private IBoardService boardService;
	
	/**
	* Method : postHandle
	* 작성자 : PC25
	* 변경이력 :
	* @param request
	* @param response
	* @param handler
	* @param modelAndView
	* @throws Exception
	* Method 설명 : 게시판을 등록/수정할 때 view로 넘어가기전 게시판을 최신화 하기
	*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (boardService.boardAllList() != null) {
			// left.jsp에서 보여지는 게시판 최신화
			request.getSession().setAttribute("boardList", boardService.boardList());
			
			// boardManager.jsp 에서 보여지는 게시판 최신화
			request.getSession().setAttribute("boardAllList", boardService.boardAllList());
		}
	}
}
