package com.spring.mvc.board.service;

import java.util.List;

import com.spring.mvc.board.model.BoardVO;

public interface IBoardService {
	// 게시글 등록 기능
	void insert(BoardVO article);

	// 게시글 전체 목록 조회 기능
	List<BoardVO> getArticleList();

	// 게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);

	// 게시글 수정 기능
	void update(BoardVO article);

	// 게시글 삭제 기능
	void delete(int boardNo);
}
