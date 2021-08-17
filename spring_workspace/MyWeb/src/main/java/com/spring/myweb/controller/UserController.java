package com.spring.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myweb.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//서비스 객체 주입
	@Autowired
	private IUserService service;
	
	
	
	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
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
}
