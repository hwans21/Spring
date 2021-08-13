package com.spring.myweb.freeboard.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;
import com.spring.myweb.util.PageVO;

@Service
public class FreeBoardService implements IFreeBoardService {

	@Autowired
	private IFreeBoardMapper mapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		mapper.regist(vo);
	}

	@Override
	public List<FreeBoardVO> getList(PageVO vo) {
		// TODO Auto-generated method stub
		List<FreeBoardVO> list = mapper.getList(vo);
		long today = System.currentTimeMillis();
		
		for(FreeBoardVO fb : list) {
			if((today - fb.getRegdate().getTime())/(24*60*60*1000) < 2){
				fb.setNewMark(true);
			}
		}
		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		// TODO Auto-generated method stub
		return mapper.getTotal(vo);
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		// TODO Auto-generated method stub
		return mapper.getContent(bno);
	}

	@Override
	public void update(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		mapper.update(vo);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
		// TODO Auto-generated method stub
		
	}
	

}
