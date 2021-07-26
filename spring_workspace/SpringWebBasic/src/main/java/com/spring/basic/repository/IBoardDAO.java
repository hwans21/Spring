package com.spring.basic.repository;

import java.util.List;

import com.spring.basic.model.BoardVO;

public interface IBoardDAO {
	// 게시글 등록
	void insertArticle(BoardVO vo);

	// 전체 게시글 목록
	List<BoardVO> getArticle();

	// 게시글 상세보기
	BoardVO getArticle(int bId);

	// 게시글 삭제
	void deleteArticle(int bId);

	// 게시글 수정
	void updateArticle(BoardVO vo, int bId);
}
