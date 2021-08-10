package com.spring.myweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.freeboard.service.IFreeBoardService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public String freeList(Model model) {
		model.addAttribute("list", service.getList());
		return "freeBoard/freeList";
	}
	
	//글 상세요청
	@GetMapping("/freeDetail")
	public void freeDetail(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("art", service.getContent(bno));
	}
	
	//글 수정 페이지 요청
	@GetMapping("/freeModify")
	public void freeModify(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("art", service.getContent(bno));
	}
	
	//글 삭제요청
	
}
