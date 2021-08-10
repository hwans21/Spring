package com.spring.myweb.freeboard;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/db-config.xml")
public class FreeboardMapperTest {
	@Autowired
	private IFreeBoardMapper mapper;
	
	// 글 등록
	@Test
	public void registTest() {
		for(int i=1;i<=320; i++) {
			FreeBoardVO vo = new FreeBoardVO();
			vo.setTitle("테스트 글쓰기"+i);
			vo.setWriter("김테스트"+i);
			vo.setContent("테스트 글쓰기 내용입니다."+i);
			mapper.regist(vo);
		}
	}
	// 글 목록
	@Test
	public void getListTest(){
		mapper.getList().forEach(vo -> System.out.println(vo));
	}
	
	// 총 게시물 수
	@Test
	public void getTotalTest() {
		System.out.println(mapper.getTotal());
	}
		
	// 상세보기
	@Test
	public void getContentTest() {
		// 119번글 확인
		System.out.println(mapper.getContent(119));
	}
	
	// 수정
	@Test
	public void updateTest() {
		//220번글 수정
		FreeBoardVO vo = new FreeBoardVO();
		vo.setBno(220);
		vo.setTitle("수정된 글 제목");
		vo.setWriter("수정된 작성자");
		vo.setContent("수정된 글 내용 블라블라");
		mapper.update(vo);
		System.out.println(mapper.getContent(220));
	}
		
	// 삭제
	@Test
	public void deleteTest() {
		//300번 글 삭제 테스트
		mapper.delete(300);
		
		mapper.getList().forEach(vo -> System.out.println(vo));
	}
}
