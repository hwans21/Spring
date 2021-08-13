package com.spring.myweb.reply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.ReplyVO;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;
import com.spring.myweb.reply.mapper.IReplyMapper;
import com.spring.myweb.util.PageVO;

@Service
public class ReplyService implements IReplyService {

	@Autowired
	private IReplyMapper mapper;
	
	@Override
	public void replyRegist(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.replyRegist(vo);
	}

//	@Override
//	public List<ReplyVO> getList(int bno) {
//		// TODO Auto-generated method stub
//		return mapper.getList(bno);
//	}
@Override
	public List<ReplyVO> getList(PageVO vo, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("paging", vo);
		datas.put("bno", bno);
		
		return mapper.getList(datas);
	}

	@Override
	public int getTotal(int bno) {
		// TODO Auto-generated method stub
		return mapper.getTotal(bno);
	}

	@Override
	public int pwCheck(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub

	}

	

}
