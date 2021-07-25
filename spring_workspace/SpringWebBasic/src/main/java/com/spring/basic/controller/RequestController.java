package com.spring.basic.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.basic.model.UserVO;


// 자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
// 빈을 등록해 놔야 HandlerMapping이 클래스의 객체를 검색할 수 있을 것이다.

@Controller
@RequestMapping("/request") //컨트롤러 자체에 공통된 URI를 맵핑
public class RequestController {
	
	
	public RequestController() {
		// TODO Auto-generated constructor stub
		System.out.println("RequestCon 생성");
	}
	
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	/*
	 만약 사용자가 /request/req 요청을 보내왔을때
	 views폴더 아래에 request폴더안에 존재하는 
	 req-ex01.jsp파일을 열도록 메서드를 구성해 보세요
	 */
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "/request/req-ex01";
	}
	
//	@RequestMapping(value="/request/basic01", method=RequestMethod.GET) spring3이전
	@GetMapping("/basic01") //spring4버전 이후
	public String basicGet() {
		System.out.println("/request/basic01 Get요청이 들어옴!");
		return "request/req-ex01";
	}
	
//	@RequestMapping(value="/request/basic01", method=RequestMethod.POST) spring3이전
	@PostMapping("basic01") //spring4버전 이후
	public String basicPost() {
		System.out.println("/request/basic01 Post요청이 들어옴!");
		return "request/req-ex01";
	}
	//////////////////////////////////////////////////////////////////////////
	
	
//	화면을 띄울 메서드부터 작성
	/*
	@GetMapping("/join")
	public String register() {
		System.out.println("/request/join : GET");
		return "request/join";
	}
	*/
//	컨트롤러 내의 메서드의 타입을 void로 선언하시면
//	요청이 들어온 URI값을 뷰 리졸버에게 전달합니다.
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET");
	}
	
	//요청 URI주소가 같더라도 전송방식에 따라 맵핑을 다르게 진행하기 때문에
	//같은 주소를 사용하는 것이 가능합니다.
	
	/*
	 1. 전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법
	 - HttpServletRequest 객체를 활용(우리가 Jsp에서 활용하던 방식)
	 귀찮아서 Spring에서는 거의 사용하지 않음(되긴함)
	 
	@PostMapping("/join")
	public void register(HttpServletRequest request) {
		System.out.println("/request/join : POST");
		System.out.println("ID : "+ request.getParameter("userId"));
		System.out.println("PW : "+ request.getParameter("userPw"));
		System.out.println("NAME : "+ request.getParameter("userName"));
		System.out.println("HOBBY : "+ Arrays.toString(request.getParameterValues("hobby")));	
	}
	
	
	*/
	/*
	 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리
	 	@RequestParam("파라미터 변수명") 값을 받아서 처리할 변수
	 	※ 값을 많이 가져오지 않을 때 사용 값을 1~2개 정도 가져올 때 사용
	 
	@PostMapping("/join")
	public void register(
			@RequestParam("userId") String id,
			@RequestParam("userPw") String pw,
			@RequestParam("userName") String name,
			@RequestParam(value="hobby", required = false, defaultValue = "no hobby person") List<String> hobbys
			) {
		System.out.println("ID: "+id);
		System.out.println("PW: "+pw);
		System.out.println("NAME: "+name);
		System.out.println("HOBBY: "+hobbys);
	}
	*/
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리
	 파라미터 데이터와 연동되는 VO클래스가 필요합니다.
	 ※ 가져올 값이 많을 때  사용
	 */
	@PostMapping("/join")
	public void register(UserVO user) {
		System.out.println(user.toString());
	}
	
	/////////////////////////////////////////////////
	@GetMapping("/quiz")
	public String quiz() {
		return "/request/req-quiz";
	}
	
	@PostMapping("/quiz")
	public String quiz(UserVO user) {
		boolean flag = false;
		if(user.getUserId().equals("abc1234")) {
			if(user.getUserPw().equals("aaa1111"))
				flag = true;
		}
		
		if(flag)
			return "/request/login-success";
		else
			return "/request/login-fail";
			
	}
	
}
