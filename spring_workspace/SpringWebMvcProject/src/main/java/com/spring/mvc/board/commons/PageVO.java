package com.spring.mvc.board.commons;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	private int page; // 사용자가 선택한 페이지 번호.
	private int countPerPage; // 사용자가 선택한 한 화면에 보여질 게시물의 개수.
	
	public PageVO() {
		// TODO Auto-generated constructor stub
		this.page = 1;
		this.countPerPage=10;
	}
}
