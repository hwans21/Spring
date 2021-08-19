package com.spring.myweb.command;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class MultiUploadVO {
	private List<UploadVO> list;
}
