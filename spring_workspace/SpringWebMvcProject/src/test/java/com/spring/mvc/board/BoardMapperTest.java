package com.spring.mvc.board;

import java.util.List;

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
	
	// 게시글 목록 전체 조회 테스트
	@Test
	public void getListTest() {
		List<BoardVO> list = mapper.getArticleList();
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("게시물 개수: "+ list.size());
	}
	
	//게시글 단일 조회 테스트
	// 44번글을 조회해서 글 상세 내용을 출력해 주세요
	@Test
	public void getContentTest() {
		BoardVO article = mapper.getArticle(44);
		System.out.println(article);
	}
	
	
	//게시글 수정 테스트
	//BoardVO 객체를 하나 생성하시고, VO의 setter를 사용하여
	//수정 내용(글 제목, 글 내용)을 입력하고 수정을 진행해 보세요(1번글의 제목, 내용 수정)
	@Test
	public void updateTest() {
		BoardVO article = new BoardVO();
		article.setBoardNum(1);
		article.setTitle("제목 수정");
		article.setContent("내용 수정");
		mapper.update(article);
		
	}
	
	
	
	//게시글 삭제 테스트
	//3번글을 삭제하세요 삭제 후 상세보기를 통해 3번글을 가져왔을 때 null이 리턴되는지
	//조건문으로 확인해서 결과를 출력하세요(null이 왔다면 -> 삭제 성공! 게시물 없음!)
	@Test
	public void deleteTest() {
		mapper.delete(3);
		if(mapper.getArticle(3)==null)
			System.out.println("삭제성공! 게시물 없음!");
	}
	
}
