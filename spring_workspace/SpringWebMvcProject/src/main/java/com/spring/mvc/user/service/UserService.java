package com.spring.mvc.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;


@Service
public class UserService implements IUserService{

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int checkId(String account) {
		// TODO Auto-generated method stub
		return mapper.checkId(account);
	}

	@Override
	public void register(UserVO user) {
		// TODO Auto-generated method stub
		// 회원 비밀번호 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 하기 전: "+user.getPassword());
		//비밀번호를 암호화해서 user객체에 다시 저장하기
		String securePw = encoder.encode(user.getPassword());
		System.out.println("암호화 한 후: "+securePw);
		user.setPassword(securePw);
		
		
		mapper.register(user);
		
	}

	@Override
	public UserVO selectOne(String account) {
		// TODO Auto-generated method stub
		return mapper.selectOne(account);
	}

	@Override
	public void delete(String account) {
		// TODO Auto-generated method stub
		mapper.delete(account);
		
	}


	@Override
	public void keepLogin(String sessionId, Date limitTime, String accuount) {
		// TODO Auto-generated method stub
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("sessionId", sessionId);
		datas.put("limitDate", limitTime);
		datas.put("account", accuount);
		
		mapper.keepLogin(datas);
	}
	
	@Override
	public UserVO getUserWithSessionId(String sessionId) {
		// TODO Auto-generated method stub
		return mapper.getUserWithSessionId(sessionId);
	}}
	
	
