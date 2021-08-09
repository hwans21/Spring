package com.spring.mvc.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

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
							HttpSession session,
							HttpServletResponse response) {
		System.out.println("/user/loginCheck: POST");
		System.out.println("param: " + vo);
		//서버에서 세션 객체를 얻는 방법
		//1.HttpServletRequest 객체 사용
		/*HttpSession session =  request.getSession();*/
		
		UserVO dbData = service.selectOne(vo.getAccount());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("dbData: "+dbData);
		
		if(dbData!=null) {
//			if(dbData.getPassword().equals(vo.getPassword())) {
			if(encoder.matches(vo.getPassword(), dbData.getPassword())) {
				session.setAttribute("login", dbData);
				long limitTime = 90*24*60*60;
				//자동 로그인 체크 시 처리해야 할 내용
				if(vo.isAutoLogin()) { // 자동 로그인을 희망.
					//쿠키를 이용하여 자동 로그인 정보를 저장
					System.out.println("자동 로그인 쿠키 생성 중 ...");
					//세션 아이드를 가지고 와서 쿠키에 저장(고유한 값이 필요해서)
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/"); // 쿠키가 동작할 수 있는 유효한 url
					loginCookie.setMaxAge((int) limitTime); //초로 시간을 받음
					response.addCookie(loginCookie);
					//자동 로그인 유지 시간을 날짜 객체로 변환.(DB에 삽입하기 위해, 밀리초)
					long expiredDate = System.currentTimeMillis() + (limitTime*1000);
					//Data 객체의 생성자에 매개값으로 밀리초의 시간을 전달하면 날짜 형태로 변경해줍니다.
					Date limitDate = new Date(expiredDate);
					service.keepLogin(session.getId(),limitDate,vo.getAccount());
				}
				
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
	public void logout(HttpSession session, RedirectAttributes ra,
							HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		System.out.println("/user/logout: GET");
		if(loginCookie != null) {
			System.out.printf("%s : %s\n",loginCookie.getName(), loginCookie.getValue());
			
		}
		
		if(session.getAttribute("login") != null) {
			//session.invalidate();
			session.removeAttribute("login");
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				loginCookie.setValue(null);
				response.addCookie(loginCookie);
			}
			ra.addFlashAttribute("msg","logout");
		}
		response.sendRedirect("/");
	}
	
}
