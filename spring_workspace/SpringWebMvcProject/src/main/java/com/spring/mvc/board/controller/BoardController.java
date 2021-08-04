package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.commons.PageCreator;
import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private IBoardService service;
	// 페이징 처리 이후 게시글 목록 불러오기 요청
	
	@GetMapping("/list")
//	public String list(PageVO paging, Model model, String keyword, String condition) {
	public String list(SearchVO search, Model model) {
		System.out.println("/board/list: GET");
	
		System.out.println("페이지 번호: "+search.getPage());
		System.out.println("페이지당 게시글 수 "+search.getCountPerPage());
		System.out.println("검색어"+search.getKeyword());
		System.out.println("검색조건"+search.getCondition());
//		List<BoardVO> list = service.getArticleList(paging,keyword,condition);
		List<BoardVO> list = service.getArticleList(search);
		System.out.println("페이징 처리 후 게시물의 수 : "+list.size());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setArticleTotalCount(service.countArticles(search));
		System.out.println("시작페이지 번호: "+pc.getBeginPage());
		
		model.addAttribute("articles", list);
		model.addAttribute("pc",pc);
		
		return "board/list";
	}
	
	/*
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.getArticleList());
		return "board/list";
	}
	*/
	
	
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	// 게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		System.out.println("/board/write: POST");
		service.insert(article);
		ra.addFlashAttribute("msg","regSuccess");
		return "redirect:/board/list";
	}
	
	//게시글 상세보기 요청
//	@GetMapping("/content/{boardNum}/{merong}")
//	public String content(@PathVariable("boardNum") int boardNum,@PathVariable("merong") int merong, Model model) {
	@GetMapping("/content/{boardNum}")
	
	//@PathVariable은 URL경로에 변수를 포함시켜 주는 방식
	//null이나 공백이 들어갈 수 있는 파라미터값이라면 적용하지 않는 것을 추천
	//파라미터값에 .이 포함되어 있으면, .뒤의 값은 잘립니다.
	//{} 안에 변수명을 지어주시고, @PathVariable 괄호 안에 영역을 지목해서 값을 받아옵니다.
//	public String content(@PathVariable("boardNum") int boardNum, Model model) {
	public String content(@PathVariable int boardNum, Model model,
						@ModelAttribute("p") PageVO paging) {
		System.out.println("/board/content?="+boardNum+": GET");
		model.addAttribute("article", service.getArticle(boardNum));
		return "/board/content";
	}
	
	//게시글 수정 화면 요청
	@GetMapping("/modify")
	public void modify(int boardNum, Model model,
					@ModelAttribute("p") PageVO paging) {
		System.out.println("/board/modify: GET");
		model.addAttribute("article",service.getArticle(boardNum));
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
