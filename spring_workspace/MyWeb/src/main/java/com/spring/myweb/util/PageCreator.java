package com.spring.myweb.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.myweb.freeboard.service.FreeBoardService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCreator {
	private PageVO page;
	private int articleTotal;
	private int begin;
	private int end;
	private boolean prev;
	private boolean next;
	
	private final static int displayNum = 5;
	
	@Autowired
	private FreeBoardService service;
	
	public void calcPaging() {
		this.end = (int) Math.ceil((double) this.page.getPageNum()/displayNum)*displayNum;
		this.begin = this.end - displayNum + 1;
		this.prev = (this.begin == 1)? false:true;
		this.next = ((this.end * this.page.getCountPerPage()) > this.articleTotal)? false:true;
		if(!next) {
			this.end = (int) Math.ceil((double) this.articleTotal/this.page.getCountPerPage());
		}
	}
	
	// 컨트롤러가 총 게시물의 개수를 PageCreator에게 전닿란 직후에
	// 페이징 버튼 알고리즘이 돌아갈 수 있도록 setter를 커스텀
	public void setArticleTotal(int total) {
		this.articleTotal= total;
		calcPaging();
	}
}
