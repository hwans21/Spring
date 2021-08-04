package com.spring.mvc.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insert(BoardVO article) {
		// TODO Auto-generated method stub
		mapper.insert(article);
	}

	@Override
//	public List<BoardVO> getArticleList(PageVO paging,String keyword, String condition) {
	public List<BoardVO> getArticleList(SearchVO search) {
		// TODO Auto-generated method stub
		
//		return mapper.getArticleList(paging, keyword,  condition);
//		Map<String, Object> datas = new HashMap<String, Object>();
//		datas.put("keyword", keyword);
//		datas.put("condition", condition);
//		datas.put("paging", paging);
//		return mapper.getArticleList(datas);
		return mapper.getArticleList(search);
	}

	@Override
	public BoardVO getArticle(int boardNo) {
		// TODO Auto-generated method stub
		mapper.updateViewCnt(boardNo);
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
		// TODO Auto-generated method stub
		mapper.update(article);
	}

	@Override
	public void delete(int boardNo) {
		// TODO Auto-generated method stub
		mapper.delete(boardNo);
	}

	@Override
	public int countArticles(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.countArticles(search);
	}

}
