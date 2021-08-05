package com.spring.mvc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
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
	
	
}
