package com.spring.mvc.board.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO extends PageVO {
	
	private String keyword;
	private String condition;
	
}
