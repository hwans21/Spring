package com.spring.mvc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("loginCheck")
	public String loginCheck(@RequestBody UserVO vo) {
		System.out.println("/user/loginCheck: POST");
		String id = vo.getAccount();
		String pw = vo.getPassword();
		if(service.checkId(id) != 1) {
			return "idFail";
		} else if(!pw.equals(service.selectOne(id).getPassword())) {
			return "pwFail";
		} else {
			return "loginSuccess";
		}
		
	}
	
	
	
}
