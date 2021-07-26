package com.spring.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.model.BoardVO;
import com.spring.basic.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//글 작성 화면을 열어주는 메서드
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	//작성된 글 등록 처리 요청
	//메서드 이름은 write() 입니다.
	// 작성된 글을 DB에 등록 후 /board/list.jsp 파일로 응답할 수 있도록
	// (글 목록 보여달라는 요청이 자동으로 들어올 수 있도록) 적절히 처리해 보세요
	@PostMapping("/write")
	public String write(BoardVO vo, Model model) {
		System.out.println("/board/write: POST");
		service.insertArticle(vo);
		return "list";
	}
	
	@GetMapping("/list")
	public void list(List<BoardVO> articles) {
	
		
	}
	
	
	// 글 목록 화면 요청
	// 메서드 이름 -> list()
	// DB대응 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
	// 바라우저에 글 목록을 띄워주시면 되겠습니다.
	// 글 목록을 table을 사용해서 간단히 만들어 주세요
	// (글 번호는 인덱스 이용해서 달아주세요.)
	
	// 글 내용 상세보기 요청 처리 메서드
	// 메서드이름 -> content, 요청 url -> /content
	// DB 역할을 하는 리스트에서 글 번호에 해당하는 글 객체를 content.jsp로 보내주세요.
	// content.jsp에서 해당 글 정보를 모두 출력해주세요.
	
}
