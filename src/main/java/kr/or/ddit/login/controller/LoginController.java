package kr.or.ddit.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private IUserService userService;
	
	@Resource(name = "boardService")
	private IBoardService boardService;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginView() {
			return "login/login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginProcess(Model model,String userId, String pass, HttpSession session) {
		
		String encryptPass = KISA_SHA256.encrypt(pass);
		
		UserVO userVo = userService.getUser(userId);
		if (userVo != null && userVo.getPass().equals(encryptPass)) {
			session.setAttribute("USER_INFO", userVo);
			if(boardService.boardAllList() != null) {
				session.setAttribute("boardAllList", boardService.boardAllList());
				session.setAttribute("boardList", boardService.boardList());
			}
			return "tiles.main";
		}else {
			model.addAttribute("userId", userId);
			return "login/login";
		}
		
		
	}
			
		
}
