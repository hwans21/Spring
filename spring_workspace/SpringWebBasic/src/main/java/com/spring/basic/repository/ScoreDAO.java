package com.spring.basic.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.basic.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	// 학생들의 점수 정보를 저장할 리스트를 생성(DB 대응)
	private List<ScoreVO> scoreList = new ArrayList<ScoreVO>();

	@Override
	public void insertScore(ScoreVO score) {
		scoreList.add(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
		return scoreList;
	}

	@Override
	public void deleteScore(int num) {
		// TODO Auto-generated method stub
		scoreList.remove(num);

	}

	@Override
	public ScoreVO selectOne(int num) {
		// TODO Auto-generated method stub
		return scoreList.get(num);
	}

}
