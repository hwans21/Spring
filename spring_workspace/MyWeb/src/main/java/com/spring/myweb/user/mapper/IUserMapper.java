package com.spring.myweb.user.mapper;

import com.spring.myweb.command.UserVO;

public interface IUserMapper {
	
	//아이디 중복 확인
	int idCheck(String id);
	
	//회원가입
	void join(UserVO vo);
	
	//로그인
	UserVO login(String id, String pw);
	
	//회원정보 얻어오기
	UserVO getInfo(String id);
}
