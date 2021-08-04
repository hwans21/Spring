package com.spring.mvc.board.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;

// 게시판 관련 CRUD 추상 메서드를 선언
public interface IBoardMapper {
	
	//게시글 등록 기능
	void insert(BoardVO article);
	
	/*
	 - MyBatis로 DB연동을 진행할 때 파라미터값이 여러 개라면
	 1. @Param을 이용해서 작성하는 법
	 2. Map으로 포장해서 보내는 법.
	 3. 객체 하나를 매개값으로 보내는 법
	 를 적절하게 상황에 맞게 선택하시면 됩니다.
	 */
	
	//페이징 처리시 게시글 전체 목록 조회 기능
	
	
//	List<BoardVO> getArticleList(PageVO paging,String keyword, String condition);
//	마이바티스는 매개값을 1개이상 보낼 수는 없다.
//	파라미터값 여러개 보내기
//	1번째 방법 @Param을 이용한 매개값 전달 방식
//	@Param("xml파일 내에서 사용할 이름") 매개변수
//	List<BoardVO> getArticleList(@Param("paging") PageVO paging,
//								@Param("keyword") String keyword, 
//								@Param("condition") String condition);
//	2번째 방법 Map으로 포장해서 보내는 방식.
//	<key, value> key:xml파일에서 사용할 이름, value: Object(타입이 여러 종류일 경우)
//	List<BoardVO> getArticleList(Map<String, Object> datas);
	
//	3번째 방법 검색 결과를 갖고 있는 객체를 매개값으로 받는 방식
	List<BoardVO> getArticleList(SearchVO search);
	
	
	
	
	
	//게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);
	
	// 게시글 수정 기능
	void update(BoardVO article);
	
	// 게시글 삭제 기능
	void delete(int boardNo);
	
	// 게시물 수 조회기능
//	예도 이제 검색 결과에 따른 게시물 수를 리턴할 수도 있어야 하기 때문에
	// 검색결과를 품고 있는 SearchVO를 매개값으로 받겠습니다.
	int countArticles(SearchVO search);
	
	//조회수 상승 처리 기능
	void updateViewCnt(int boardNo);
	
}
