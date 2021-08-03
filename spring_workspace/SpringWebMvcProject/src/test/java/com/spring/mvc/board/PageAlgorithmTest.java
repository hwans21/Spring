package com.spring.mvc.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"}) // 데이터베이스 연동을 위해 mvc-config.xml을 가져옴
public class PageAlgorithmTest {
	/*
	 *** 페이징 알고리즘 만들기 ***
	 # 1. 총 게시물 수의 수를 조회해야 합니다.
	 - 총 게시물 수는 DB로부터 수를 조회하는 SQL문 작성
	 
	 # 2. 사용자가 현재 위치한 페이지를 기준으로
	 끝 페이지 번호를 계산하는 로직 작성
	 
	 - 만약 현재 사용자가 보고 잇는 페이지가 3페이지고,
	 한 화면에 보여줄 페이지 버튼이 10개씩이면? -> 끝페이지 : 10페이지
	 
	공식 : Math.ceil(현재 위치한 페이지 번호 / 페이지 버튼 개수) * 페이지 버튼 개수
			└올림 함수
			
	# 3. 시작페이지 번호 구하기
	공식 (끝페이지 번호 - 페이지 버튼 개수) +1

	# 4. 이전 버튼 활성 여부
	공식 : 시작페이지가 1이면 비활성, 나머지는 모두 활성
	
	# 5. 다음 버튼 활성여부
	공식 : 보정 전 끝 페이지 번호 * 한 페이지에 들어갈 게시물의 수 >= 총 게시물 수
	 -> 비활성.
	 
	 # 6. 끝 페이지 값 보정
	 - 다음 버튼이 비활성화 되었을 때 사용. (필요없는 버튼을 제거하는 용도)
	 - 공식 : Math.ceil(총 게시물 수 / 한 페이지에 보여줄 게시물의 수)
	 */
	

	@Autowired
	private IBoardMapper mapper;
	
	@Test
	public void pagingAlgorithmTest() {
		// 총 게시물 수 구하는 테스트
		System.out.println("--------------------------");
		System.out.println(mapper.countArticles());
		System.out.println("--------------------------");

		// 끝 페이지 번호 계산 테스트
		PageVO vo = new PageVO();
		vo.setPage(12);
		vo.setCountPerPage(20);
		int buttonNum = 20; //한 화면에 보여질 버튼 개수
		int endPage = (int) (Math.ceil((double)vo.getPage()/buttonNum)*buttonNum);
		System.out.println("--------------------------");
		System.out.println("끝 페이지 번호 : "+ endPage);
		System.out.println("--------------------------");
		
		//시작페이지 번호 계산 테스트
		int beginPage = endPage - buttonNum + 1;
		System.out.println("--------------------------");
		System.out.println("시작 페이지 번호 : "+ beginPage);
		System.out.println("--------------------------");
		
		//이전버튼 활성 여부
		boolean isPrev = (beginPage == 1)? false : true;
		
		//다음버튼 활성 여부
		boolean isNext = (endPage * vo.getCountPerPage() >= mapper.countArticles()) ? false : true;
		
		System.out.println("--------------------------");
		System.out.println("이전버튼 활성화 여부 : "+ isPrev);
		System.out.println("다음버튼 활성화 여부 : "+ isNext);
		System.out.println("--------------------------");
		
		//끝 페이지 수 보정
		if(!isNext)
			endPage = (int) (Math.ceil((double)mapper.countArticles()/vo.getCountPerPage()));
		System.out.println("--------------------------");
		System.out.println("끝 페이지 번호 : "+ endPage);
		System.out.println("--------------------------");
	}
}
