package kr.or.ddit.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVO;

@RequestMapping("board")
@Controller
public class BoardController {

	@Resource(name = "boardService")
	private IBoardService boardService;
	
	/**
	* Method : boardManager
	* 작성자 : PC25
	* 변경이력 :
	* @param request
	* @return
	* Method 설명 : 게시판 메인
	*/
	@RequestMapping("/boardManager")
	public String boardManager(HttpServletRequest request) {
		
		return "tiles.boardManager";
	}
	
	

	/**
	* Method : createBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param createBoardName
	* @param use_yn
	* @param request
	* @return
	* Method 설명 :게시판 생성
	*/
	@RequestMapping(path = "/createBoard", method = RequestMethod.POST)
	public String createBoard(String createBoardName, String use_yn, HttpServletRequest request) {
		
		// 게시판 전체 수 + 1
		int id = boardService.boardCnt();
		
		// 로그인 할때 세션에 담겨있던 사용자 아이디
		String userId = ((UserVO)request.getSession().getAttribute("USER_INFO")).getUserId();
		BoardVO boardVo = new BoardVO(id, userId, createBoardName, use_yn);
		
		// 게시판 등록
		boardService.insertBoard(boardVo);
		
		return "redirect:/board/boardManager";
		
	}
	
	/**
	* Method : updateBoard
	* 작성자 : PC25
	* 변경이력 :
	* @param id
	* @param use_yn
	* @return
	* Method 설명 : 게시판 사용 여부 수정
	*/
	@RequestMapping(path = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(int id, String updateUse_yn) {
		
		// 게시판 아이디에 해당하는 게시판 정보 
		BoardVO boardVo = boardService.getBoard(id);
		
		// 게시판의 사용여부를 셋팅
		boardVo.setUse_yn(updateUse_yn);
		
		// 게시판 사용여부 수정
		boardService.updateBoard(boardVo);
		
		return "redirect:/board/boardManager";
	}
}
