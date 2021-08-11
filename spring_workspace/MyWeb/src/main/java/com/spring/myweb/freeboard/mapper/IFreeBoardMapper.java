package com.spring.myweb.freeboard.mapper;

import java.util.List;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.util.PageVO;

public interface IFreeBoardMapper {
	// 글 등록
	void regist(FreeBoardVO vo);
	
	// 글 목록
	List<FreeBoardVO> getList(PageVO vo);
	
	// 총 게시물 수
	int getTotal(PageVO vo);
	
	// 상세보기
	FreeBoardVO getContent(int bno);
	
	// 수정
	void update(FreeBoardVO vo);
	
	// 삭제
	void delete(int bno);
}
