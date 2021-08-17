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
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
