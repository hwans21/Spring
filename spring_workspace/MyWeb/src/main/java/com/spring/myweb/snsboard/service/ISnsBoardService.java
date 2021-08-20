package com.spring.myweb.snsboard.service;

import java.util.List;

import com.spring.myweb.command.SnsBoardVO;

public interface ISnsBoardService {
	//등록
		void insert(SnsBoardVO vo);
		
		//목록
		List<SnsBoardVO> getList();
		
		//상세
		SnsBoardVO getDetail(int bno);
		
		//삭제
		void delete(int bno);
}
