package com.spring.db.repository;

import java.util.List;

import com.spring.db.model.BoardVO;

public interface IBoardMapper {
	// 게시글 등록
		void insertArticle(BoardVO vo);

		// 전체 게시글 목록
		List<BoardVO> getArticle();

		// 게시글 상세보기
		BoardVO getArticleOne(int bId);

		// 게시글 삭제
		void deleteArticle(int bId);

		// 게시글 수정
		void updateArticle(BoardVO vo);

		// 게시글 검색
		List<BoardVO> searchArticle(String keyword);
}
