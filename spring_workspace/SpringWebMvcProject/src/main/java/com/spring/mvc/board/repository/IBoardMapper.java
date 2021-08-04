package com.spring.mvc.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.model.BoardVO;

// 게시판 관련 CRUD 추상 메서드를 선언
public interface IBoardMapper {
	
	//게시글 등록 기능
	void insert(BoardVO article);
	
	//페이징 처리시 게시글 전체 목록 조회 기능
//	List<BoardVO> getArticleList(PageVO paging,String keyword, String condition);
//	마이바티스는 매개값을 1개이상 보낼 수는 없다.
//	파라미터값 여러개 보내기
//	1번째 방법
	List<BoardVO> getArticleList(@Param("paging") PageVO paging,
								@Param("keyword") String keyword, 
								@Param("condition") String condition);
	
	//게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);
	
	// 게시글 수정 기능
	void update(BoardVO article);
	
	// 게시글 삭제 기능
	void delete(int boardNo);
	
	// 게시물 수 조회기능
	int countArticles();
	
}
