package com.spring.mvc.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	// Mapper 계층의 객체 필요
	@Autowired
	private IUserMapper mapper;
	
	//회원가입을 아무아이디로 진행해보세요
	@Test
	public void insertTest() {
		UserVO user = new UserVO();
		user.setAccount("test");
		user.setName("testname");
		user.setPassword("1q2w3e4r");
		
		mapper.register(user);
	}
	
	//위에서 회원 가입한 아이디로 중복확인을 해서
	//count(*)를 이용해서 1이 리턴이 되는지 확인하세요
	@Test
	public void checkAccountTest() {
		String account = "test";
		System.out.println(mapper.checkId(account));
	}
	
	
	//가입한 회원의 모든 정보를 얻어서 출력해보세요
	@Test
	public void membersInfo() {
		
		System.out.println(mapper.selectOne("test"));
		// toString은 안써도 메서드를 쓴 것처럼 출력이 됨
		
	}
	
	//위에서 가입한 계정의 탈퇴를 진행해 보세요
	//탈퇴가 성공했는지의 여부도 체크해보세요
	@Test
	public void memberDeleteTest() {
		String account = "test";
		mapper.delete(account);
//		if(mapper.checkId(account) == 1) {
//			System.out.println("탈퇴 실패");
//		} else {
//			System.out.println("탈퇴 성공");
//		}
		
		if(mapper.selectOne(account)!=null) {
			System.out.println("탈퇴 실패");
		} else {
			System.out.println("탈퇴 성공");
		}
		
	}
}
