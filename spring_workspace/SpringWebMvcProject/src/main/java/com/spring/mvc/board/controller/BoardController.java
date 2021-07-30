package com.spring.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.board.model.BoardVO;
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
	
	// 게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write: POST");
		service.insert(article);
		return "redirect:/board/list";
	}
	
	//게시글 상세보기 요청
	@GetMapping("/content")
	public String content(@RequestParam("boardNo") int boardNo, Model model) {
		System.out.println("/board/content?="+boardNo+": GET");
		model.addAttribute("article", service.getArticle(boardNo));
		return "";
	}
	
	//게시글 수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify: POST");
		System.out.println("요청된 글 번호: "+article.getBoardNum());
		service.update(article);
		return "redirect:/board/content?boardNo="+article.getBoardNum();
	}
	
	@PostMapping("/delete")
	public String delete(/* @RequestParam("boardNum") int boardNo */ int boardNum) {
		System.out.println("/board/delete: POST");
		System.out.println("요청된 글 번호: "+ boardNum);
		service.delete(boardNum);
		return "redirect:/board/list";
	}
}
