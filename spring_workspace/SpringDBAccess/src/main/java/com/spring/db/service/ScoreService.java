package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.ScoreVO;
import com.spring.db.repository.IScoreDAO;


@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO score) {
		// TODO Auto-generated method stub
		score.calcData();
		dao.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
//		List<ScoreVO> list = dao.selectAllScores();
//		return list;
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int num) {
		// TODO Auto-generated method stub
		dao.deleteScore(num);
	}

	@Override
	public ScoreVO selectOne(int num) {
		// TODO Auto-generated method stub
		
		return dao.selectOne(num);
		
	}

}
