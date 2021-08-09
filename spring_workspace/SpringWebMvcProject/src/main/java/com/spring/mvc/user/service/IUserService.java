package com.spring.mvc.user.service;

import java.util.Date;

import com.spring.mvc.user.model.UserVO;

public interface IUserService {


	//아이디 중복 체크 기능 >> boolean으로 안하고 int로 한 이유 로그인처리까지 활용하기 위해서
		int checkId(String account);
		
		//회원 가입 기능
		void register(UserVO user);
		
		//회원 정보 조회 기능
		UserVO selectOne(String account);
		
		//회웥 탈퇴
		void delete(String account);
		
		//자동로그인 추가 정보 저장
		void keepLogin(String sessionId, Date limitTime, String account);
		
		//세션아이디를 통해 회원 정보 가져오기
		UserVO getUserWithSessionId(String sessionId);
}
