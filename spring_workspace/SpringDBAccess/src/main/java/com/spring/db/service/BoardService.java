package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.BoardVO;
import com.spring.db.repository.IBoardDAO;
import com.spring.db.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insertArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticle() {
		// TODO Auto-generated method stub
		return mapper.getArticle();
	}

	@Override
	public BoardVO getArticleOne(int bId) {
		// TODO Auto-generated method stub
		return mapper.getArticleOne(bId);
	}

	@Override
	public void deleteArticle(int bId) {
		// TODO Auto-generated method stub
		mapper.deleteArticle(bId);
	}

	@Override
	public void updateArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.updateArticle(vo);
	}

	@Override
	public List<BoardVO> searchArticle(String keyword) {
		// TODO Auto-generated method stub
		keyword = '%'+keyword+'%';
		return mapper.searchArticle(keyword);
	}

//	@Autowired
//	private IBoardDAO dao;
	
//	@Override
//	public void insertArticle(BoardVO vo) {
//		// TODO Auto-generated method stub
//		dao.insertArticle(vo);
//	}
//
//	@Override
//	public List<BoardVO> getArticle() {
//		// TODO Auto-generated method stub
//		return dao.getArticle();
//	}
//
//	@Override
//	public BoardVO getArticle(int bId) {
//		// TODO Auto-generated method stub
//		return dao.getArticle(bId);
//	}
//
//	@Override
//	public void deleteArticle(int bId) {
//		// TODO Auto-generated method stub
//		dao.deleteArticle(bId);
//	}
//
//	@Override
//	public void updateArticle(BoardVO vo) {
//		// TODO Auto-generated method stub
//		dao.updateArticle(vo);
//	}
//
//	@Override
//	public List<BoardVO> searchArticle(String keyword) {
//		// TODO Auto-generated method stub
//		keyword = '%'+keyword+'%';
//		return dao.searchArticle(keyword);
//	}

	
}
