package com.spring.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myweb.command.ReplyVO;
import com.spring.myweb.reply.service.IReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private IReplyService service;
	
	@PostMapping("/replyRegist")
	public String replyRegist(@RequestBody ReplyVO vo) {
		service.replyRegist(vo);
		return "regSucess";
	}
	
	@GetMapping("/getList/{bno}")
	public List<ReplyVO> getList(@PathVariable int bno){
		List<ReplyVO> list = service.getList(bno);
		System.out.println("댓글 개수 : "+list.size());
		return list;
	}
}
