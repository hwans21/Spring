package com.spring.myweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;
import com.spring.myweb.util.PageCreator;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public String freeList(Model model, PageVO page) {
		System.out.println("/freeBoard/freeList: GET");
		PageCreator pc = new PageCreator();
		pc.setPage(page);
		pc.setArticleTotal(service.getTotal(page));
		model.addAttribute("pc", pc);		
		model.addAttribute("list", service.getList(page));
		return "freeBoard/freeList";
	}
	
	
	// 글 등록화면요청
	@GetMapping("/freeRegist")
	public void freeRegist() {
		System.out.println("/freeBoard/freeRegist: GET");
	}
	
	// 글 등록처리
	@PostMapping("/registForm")
	public String registForm(FreeBoardVO vo, RedirectAttributes ra) {
		System.out.println("/freeBoard/freeRegist: POST");
		service.regist(vo);
		
		//등록 성공 여부를 1회용으로 전달하기 위한 ra객체의 메서드
		ra.addFlashAttribute("msg","정상 등록 처리되었습니다.");
		return "redirect:/freeBoard/freeList"; // 등록 후에 글 목록 요청 리다이렉트
	}
	
	//글 상세보기요청
	@GetMapping("/freeDetail")
	public void getContent(@RequestParam int bno, Model model) {
		System.out.println("/freeBoard/freeDetail: GET");
		model.addAttribute("art", service.getContent(bno));
		
	}
	
	//글 수정 페이지 요청
	@GetMapping("/freeModify")
	public void freeModify(@RequestParam int bno, Model model) {
		System.out.println("/freeBoard/freeModify: GET");
		model.addAttribute("art", service.getContent(bno));
	}
	
	@PostMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes ra) {
		System.out.println("/freeBoard/freeUpdate: POST");
		service.update(vo);
		ra.addFlashAttribute("msg", "updateSuccess");
		return "redirect:/freeBoard/freeDetail?bno="+vo.getBno();
	}
	
	//글 삭제요청
	@PostMapping("/freeDelete")
//	public String freeDelete(@RequestParam int bno, RedirectAttributes ra) {
	public String freeDelete(FreeBoardVO vo, RedirectAttributes ra) {
		System.out.println("/freeBoard/freeDelete: POST");
		
//		service.delete(bno);
		service.delete(vo.getBno());
		ra.addFlashAttribute("msg","게시글이 정상 삭제되었습니다.");
		return "redirect:/freeBoard/freeList";
	}
}
