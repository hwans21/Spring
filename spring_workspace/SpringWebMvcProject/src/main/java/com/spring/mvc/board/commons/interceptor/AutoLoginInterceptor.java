package com.spring.mvc.board.commons.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private IUserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("자동 로그인 인터셉터 발동");
		
		// 1. 자동로그인 쿠키가 있는지의 여부 확인
		//-> loginCookie의 존재 여부를 확인
		//전통적인 쿠키 확인 방식
//		Cookie[] cookies = request.getCookies();
//		if(cookies !=null) {
//			for(Cookie c : cookies) {
//				if(c.getName().equals("loginCookie")) {
//					///
//				}
//			}
//		}
		
		
		//원하는 쿠키의 값을 한방에 꺼내오실 수 있습니다.(request객체, 쿠키이름)
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		HttpSession session = request.getSession();
		if(loginCookie != null) { // 자동로그인을 이전에 신청한 유저 라면~
			
			//2. DB에서 쿠키값(세션id)과 일치하는 세션아이디를 가진 회원의 정보를 조회.
			UserVO vo = service.getUserWithSessionId(loginCookie.getValue());
			System.out.println("쿠키의 값: "+loginCookie.getValue());
			System.out.println("DB에서 가지고 온 값: "+ vo);
			if(vo != null) {
				//자동 로그인 신청한 사람의 로그인 데이터(세션)를 만들어 줍시다.
				session.setAttribute("login", vo);
				System.out.println("세션 제작 완료!");
			}
			
		}
		
		
		//true이면 컨트롤러로 요청이 들어가고, false면 요청을 막습니다.
		//true를 쓴 이유는 자동 로그인 신청 여부와 상관없이 홈 화면은 
		//누구나 봐야하지 않겠습니까?
		return true;
	}
}
