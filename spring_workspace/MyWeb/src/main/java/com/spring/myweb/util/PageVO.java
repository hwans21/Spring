package com.spring.myweb.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	
	//사용자가 선택한 페이지 정보를 담을 변수
	private int pageNum;
	private int countPerPage;
	
	// 검색에 필요한 데이터를 변수로 선언
	private String keyword;
	private String condition;
	
	public PageVO() {
		this.pageNum = 1;
		this.countPerPage = 20;
	}
}
