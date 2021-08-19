package com.spring.myweb.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.mapper.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return mapper.idCheck(id);
	}

	@Override
	public void join(UserVO vo) {
		mapper.join(vo);

	}

	@Override
	public UserVO login(String id, String pw) {
		return mapper.login(id, pw);
	}

	@Override
	public UserVO getInfo(String id) {
		// TODO Auto-generated method stub
		return mapper.getInfo(id);
	}

	@Override
	public void modify(UserVO vo) {
		// TODO Auto-generated method stub
		mapper.modify(vo);
	}

}
