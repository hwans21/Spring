package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.basic.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	
	/*
	 * 1. Model 객체를 사용하여 화면에 데이터 전송하기
	@GetMapping("/test")
	public void test(@RequestParam("age") int age, Model model) {
//		System.out.println(age);
		model.addAttribute("age", age);
		model.addAttribute("nick", "멍멍이");
	}
	*/
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송 처리
	// @RequestParam + model.addAttribute 같이 작동

	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) {
		model.addAttribute("nick","멍멍이");
		
	}
	
	@GetMapping("/test2")
	public void test2(@ModelAttribute("info") UserVO vo) {
		System.out.println("메서드 내의 콘솔 출력 : " + vo);
	}
	
	//3. ModelAndView 객체를 활용한 처리
//	비동기방식에서 사용될 수 있음..(아직까진 모르겠음)
	@GetMapping("/test3")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName","김철수");
		mv.addObject("userAge",30);
		mv.setViewName("/response/test3");		
		return mv;
	}
	
	@GetMapping("/res-quiz01")
	public void resQuiz() {
		
	}
	
	@PostMapping("/res-login")
	public String resQuiz(@ModelAttribute("info") UserVO vo) {
		if(vo.getUserId().equals("kim1234") && vo.getUserPw().equals("1234"))
			return "/response/res-quiz02";
		else
			return "/response/res-quiz03";
	}
//	@PostMapping("/res-login")
//	public String resLogin(UserVO vo, Model model) {
//		String id = vo.getUserId();
//		String pw = vo.getUserPw();
//		
//		model.addAttribute("userId", id);
//		
//		if(id.equals("kim1234") && pw.equals("1234")) 
//			return "response/res-quiz02";
//		else
//			return "response/res-quiz03";
//	}
	
//	@PostMapping("/res-login")
//	public String resLogin(@ModelAttribute("userId") String id,
//						@RequestParam("userPw") String pw) {
//		if(id.equals("kim1234")&&pw.equals("1234"))
//			return "response/res-quiz02";
//		else
//			return "response/res-quiz03";
//	}
	
	
	////////////////////////////////////
	//Redirect 처리
	
	@GetMapping("/login")
	public String login() {
		System.out.println("/login: GET요청 발생!");
		return "response/res-redirect-form";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId") String id,
						@RequestParam("userPw") String pw,
						@RequestParam("userPwChk") String pwChk,
						RedirectAttributes ra) {
		System.out.println("/login: POST요청 발생!");
		System.out.println("ID: "+id);
		System.out.println("PW: "+pw);
		System.out.println("chk: "+pwChk);
		if(id.equals("")) {
			// redirect 상황에서 model객체를 사용하게 되면
			// model 내부의 데이터가 재 요청이 들어올 때 파라미터값으로 붙어서 들어옵니다.
			// 데이터가 url주소 뒤에 ?와 함께 노출되어 전달됩니다.
//			model.addAttribute("msg","아이디는 필수값이에요!");
			ra.addFlashAttribute("msg", "아이디는 필수값이에요!"); 
//			ra.addAttribute("msg", "아이디는 필수값이에요!");
			return "redirect:/response/login";
		} else if(!pw.equals("pwChk")) {
			ra.addFlashAttribute("msg","비밀번호 확인란을 체크하세요!");
			return "redirect:/response/login";
		}
		return "";
		
	}
}
