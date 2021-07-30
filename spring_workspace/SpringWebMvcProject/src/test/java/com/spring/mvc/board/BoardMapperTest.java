package com.spring.mvc.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

//	DB 연동 테스트 하기 위한 클래스
//	- sqlSessionFactory >> mvc-config.xml -> url, uid, upw
// mvc-config.xml을 적용시키기 위한 아노테이션(메인메서드 x 객체 x 테스트 가능하게 끔 함)
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"/*,"file:~"*/})
public class BoardMapperTest {
	
	@Autowired
	private IBoardMapper mapper;
	
	// 게시글 등록 단위 테스트
	@Test
	public void insertTest() {
		for(int i=1;i<=300;i++) {
			BoardVO article = new BoardVO();
			article.setTitle("테스트 제목입니다."+i);
			article.setWriter("김테스트"+i);
			article.setContent("테스트 중이니까 조용히 하세요!" + i);
			mapper.insert(article);
		}
	}
	
}
