package com.spring.mvc.board;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.junit.Test;

@Test
public class UriComponentTest {
	
	public void testUriComp() {
		//uri를 쉽게 작성할 수 있도록 도와주는 유틸 클래스
		//UriComponentsBuilder 사용하기
		UriComponents ucp = UriComponentsBuilder.newInstance().path("/board/list")
				.queryParam("page", 3)
				.queryParam("countPerPage", 20)
				.queryParam("keyword", "메롱")
				.queryParam("countPerPage", "title")
				.build();
		System.out.println(ucp.toUriString());
	}
	
}
