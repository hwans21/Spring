package com.spring.mvc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*
 @ResponseBody
 - 리턴 데이터를 viewResolver에게 전달하지 않고
 클라이언트에게 해당 데이터를 바로 응답하게 합니다.
 - @RestController를 사용하면 모든 메서드에
 @ResponseBody를 붙인 결과와 같습니다.
 
 */


@Controller
@RestController // 스프링 4 이상부터 가능
@RequestMapping("/rest")
public class RestControllerTest {
	@GetMapping("/hello")
//	@ResponseBody
	public String hello() {
		
		return "Hello World!!!";
	}
	
	@GetMapping("/hobbys")
	public List<String> hobbys(){
		List<String> hobbys = Arrays.asList("축구","수영","영화감상");
		return hobbys;
	}
	
	@GetMapping("/study")
	public Map<String, Object> study(){
		Map<String, Object> subject = new HashMap<String, Object>();
		subject.put("자바", "java");
		subject.put("put", "java server pages");
		subject.put("spring", "spring framework5");
		return subject;
		
	}
	@GetMapping("/person")
	public Person person() {
		Person p = new Person();
		p.setName("김철수");
		p.setAge(30);
		p.setHobbys(Arrays.asList("수영","독서","축구"));
		return p;
	}
	
	@GetMapping(value = "/getText", produces = "text/plain")
	public String getText() {
		System.out.println("/getText 요청이 들어옴!");
		return "Hello world";
	}
	
	@PostMapping("/getObject") 
	public Person getObject(@RequestBody Person person) {
		System.out.println("/getObject 요청이 들어옴!");
		System.out.println("이름: "+person.getName());
		System.out.println("나이: "+person.getAge());
		System.out.println("취미: "+person.getHobbys());
		
		person.setAge(40);
		return person;
	}
	
	@GetMapping("/getPath/{sort}/{page}/{cpp}")
	public Map<String, String> getPath(@PathVariable("sort") String sort,
									@PathVariable("page") String page,
									@PathVariable("cpp") String cpp){
		
		
		Map<String, String> map = new HashMap<>();
		map.put("종류", sort);
		map.put("페이지번호", page);
		map.put("게시물개수", cpp);
		
		
		return map;
	}
	
	
	
	
}


