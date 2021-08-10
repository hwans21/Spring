package com.spring.myweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.freeboard.service.IFreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("boardService")
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public String freeList(Model model) {
		model.addAttribute("list", service.getList());
		return "freeBoard/freeList";
	}
	
}
