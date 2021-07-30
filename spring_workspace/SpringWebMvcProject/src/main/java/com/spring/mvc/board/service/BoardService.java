package com.spring.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<BoardVO> getArticleList() {
		// TODO Auto-generated method stub
		
		return mapper.getArticleList();
	}

	@Override
	public BoardVO getArticle(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int boardNo) {
		// TODO Auto-generated method stub

	}

}
