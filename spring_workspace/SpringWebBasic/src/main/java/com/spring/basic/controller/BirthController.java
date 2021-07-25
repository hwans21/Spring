package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.model.BirthVO;

@Controller
@RequestMapping("/birth")
public class BirthController {
	
	
	@GetMapping("")
	public String birthForm() {
		return "/birth/birth-form";
	}
	
	@PostMapping("")
	public String birthResult(@ModelAttribute("birth") BirthVO vo) {
		String year = vo.getYear();
		String month = vo.getMonth();
		String day = vo.getDay();
		System.out.println(year+month+day);
		return "/birth/birth-result";
	}
}
