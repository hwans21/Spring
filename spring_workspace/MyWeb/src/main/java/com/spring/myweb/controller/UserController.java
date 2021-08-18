package com.spring.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//서비스 객체 주입
	@Autowired
	private IUserService service;
	
	
	//회원가입 페이지 이동
	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	//아이디 중복확인(비동기)
	@ResponseBody //Rest Controller가 아닌경우에는 아노테이션을 붙여야 통신이 가능하다.
	@PostMapping("/idCheck")
	public String idCheck(@RequestBody String userId) {
		System.out.println(userId);
		if(service.idCheck(userId) == 1) {
			return "duplicated";
		} else {
			return "ok";
		}
		
	}
	//회원 가입 처리
	@PostMapping("/join")
	public String join(UserVO vo, RedirectAttributes ra) {
		service.join(vo);
		ra.addAttribute("msg", "joinSuccess");
		
		return "redirect:/user/userLogin";
	}
	
	//로그인 페이지 이동 요청
	@GetMapping("/userLogin")
	public void userLogin() {}
	
	//로그인 처리
	@PostMapping("/login")
	public String login(String userId, String userPw, Model model
					    , RedirectAttributes ra) {
		UserVO vo = service.login(userId, userPw);
		
		System.out.println("param: " + userId + ", " + userPw);
		
		System.out.println("vo: " + vo);
		
		model.addAttribute("user", vo);
		
		return "/user/userLogin";
		
//		if(vo != null) { //로그인 성공
//			model.addAttribute("vo", vo);
//			return "redirect:/";
//		} else {
//			ra.addFlashAttribute("msg", "loginFail");
//			return "redirect:/user/userLogin";
//		}
	}
	
	@GetMapping("/userMyPage")
	public String userMyPage(HttpSession session, Model model) {
		
		//세션데이터에서 id를 뽑아야 sql문을 돌릴 수 있겠죠?
//		String id = ((UserVO) session.getAttribute("login")).getUserId();
		UserVO vo = (UserVO) session.getAttribute("login");
		String userId = vo.getUserId();
		
		//위의 UserVO랑은 다릅니다. JOIN문법을 통해 게시글까지 가져온 UserVO입니다.
		UserVO userInfo = service.getInfo(userId);
		model.addAttribute("userInfo", userInfo);
		
		return "user/userMypage";
	}
}
