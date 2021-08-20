package com.spring.myweb.snsboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.snsboard.mapper.ISnsBoardMapper;

@Service
public class SnsBoardService implements ISnsBoardService {
	@Autowired
	private ISnsBoardMapper mapper;
	
	@Override
	public void insert(SnsBoardVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
	}

	@Override
	public List<SnsBoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public SnsBoardVO getDetail(int bno) {
		// TODO Auto-generated method stub
		return mapper.getDetail(bno);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub

	}

}
