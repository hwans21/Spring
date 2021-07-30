package com.spring.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private IBoardService service;
	
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.getArticleList());
		return "board/list";
	}
}
