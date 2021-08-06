package com.spring.mvc.board.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터 클래스를 만드려면 HandlerInterceptorAdapter 클래스를 상속합니다.

public class BoardInterceptor extends HandlerInterceptorAdapter {
	
	
	//preHandle은 컨트롤러로 들어가기 전 처리해야할 로직을 작성.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("게시판 인터셉터 preHandle 호출");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			System.out.println("회원 인증 실패!");
			response.sendRedirect("/board/list");
			return false; //false를 리턴하면 컨트롤러로 요청이 전달되지 않습니다.
		} else {
			System.out.println("회원 인증 성공!");
			return true; //true를 리턴하면 아무 일도 일어나지 않고 요청이 전달됩니다.
			
		}
	}
	
	
	//postHandle은 컨트롤러를  나갈 때 공통 처리해야 할 내용을 작성.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("게시판 인터셉터 postHandle 호출");
		
		System.out.println("모델 객체의 내부: "+modelAndView.getModel());
		
		Object data = modelAndView.getModel().get("article");
		System.out.println("article이라는 이름의 데이터: "+data);
		
		// 컨트롤러에서 로직을 처리하고 나가는 흐름을 붙잡아서 
		// 모델 데이터가 제대로 전송이 되는지 확인하고, 추가할 내용이나 수정할 내용이 있다면
		// 모델 객체를 받아와서 수정도 가능합니다.
		// 기타 특징을 이용하여 흐름을 제어할 수도 있습니다.
	}
	
	
}
