package com.spring.mvc.test;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
	private String name;
	private int age;
	private List<String> hobbys;
}
