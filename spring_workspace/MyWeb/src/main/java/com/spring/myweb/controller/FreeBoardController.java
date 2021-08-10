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

import com.spring.myweb.command.FreeBoardVO;
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
		System.out.println("/freeBoard/freeList: GET");
		model.addAttribute("list", service.getList());
		return "freeBoard/freeList";
	}
	
	//글 상세요청
	@GetMapping("/freeDetail")
	public void freeDetail(@RequestParam("bno") int bno, Model model) {
		System.out.println("/freeBoard/freeDetail: GET");
		model.addAttribute("art", service.getContent(bno));
		
	}
	
	// 글 등록화면요청
	@GetMapping("/freeRegist")
	public void freeRegist() {
		System.out.println("/freeBoard/freeRegist: GET");
	}
	
	// 글 등록요청
	@PostMapping("/freeRegist")
	public String freeRegist(FreeBoardVO vo) {
		System.out.println("/freeBoard/freeRegist: POST");
		service.regist(vo);
		return "redirect:/freeBoard/freeList";
	}
	
	//글 수정 페이지 요청
	@GetMapping("/freeModify")
	public void freeModify(@RequestParam("bno") int bno, Model model) {
		System.out.println("/freeBoard/freeModify: GET");
		model.addAttribute("art", service.getContent(bno));
	}
	
	//글 삭제요청
	@PostMapping("/freeDelete")
	public void freeDelete() {
		System.out.println("/freeBoard/freeDelete: POST");
	}
}
