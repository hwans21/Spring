package com.spring.mvc.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/mvc-config.xml",
						"file:src/main/webapp/WEB-INF/spring/servlet-config.xml" })
@Log4j
public class BoardControllerTest {
	
	
	// 테스트 환경에서 가상의 DispatcherServlet을 사용하기 위한 객체 자동 주입.
	// WebApplicationContext는 Spring에서 제공되는 servlet들을 사용할 수 있도록
	// 정보를 저장하는 객체입니다.
	@Autowired
	private WebApplicationContext ctx;
	
	//mock:모방, 가상의
	// 요청과 응답을 넣을 수 있게 가상의 mvc환경을 구성할 수 있도록 함
	//MockMvc는 웹 어플리케이션을 서버에 배포하지 않아도 스프링 MVC 동작을
	//구현할 수 있는 가상의 구조를 만들어 줍니다.
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		// 가상 구조를 세팅
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
}
