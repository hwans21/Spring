package com.spring.mvc.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	//아이디 중복 여부 처리
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		System.out.println("/user/checkId : POST");
		System.out.println("param: "+account);
		int checkNum = service.checkId(account);
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨!");
			return "duplicated";
		} else {
			System.out.println("아이디 사용가능!");
			return "available";			
		}
	}
	
	//회원 가입 요청 처리
	@PostMapping("/")
	public String register(@RequestBody UserVO vo) {
		System.out.println("/user/: POST");
		service.register(vo);
		return "joinSuccess";
	}
	
	
	// 로그인 요청 처리
	@PostMapping("loginCheck")
	public String loginCheck(@RequestBody UserVO vo,
							/*HttpServletRequest request*/
							HttpSession session) {
		System.out.println("/user/loginCheck: POST");
		System.out.println("param: " + vo);
		//서버에서 세션 객체를 얻는 방법
		//1.HttpServletRequest 객체 사용
		/*HttpSession session =  request.getSession();*/
	
		UserVO dbData = service.selectOne(vo.getAccount());
		if(dbData!=null) {
			if(dbData.getPassword().equals(vo.getPassword())) {
				session.setAttribute("login", dbData);
				return "loginSuccess";
			} else {
				return "pwFail";
				
			}
		} else {
			return "idFail";
		}
		
//		String id = vo.getAccount();
//		String pw = vo.getPassword()ㅔㅔ;
//		if(service.checkId(id) != 1) {
//			return "idFail";
//		} else if(!pw.equals(service.selectOne(id).getPassword())) {
//			return "pwFail";
//		} else {
//			return "loginSuccess";
//		}
		
	}
	
	// 로그아웃 요청 처리
	@GetMapping("/logout")
//	public String logout(HttpSession session, RedirectAttributes ra) {
	public ModelAndView logout(HttpSession session, RedirectAttributes ra) {
		System.out.println("/user/logout: GET");
		if(session.getAttribute("login") != null) {
			//session.invalidate();
			session.removeAttribute("login");
			ra.addFlashAttribute("msg","logout");
		}
	
		return new ModelAndView("redirect:/");
	}
	
}
