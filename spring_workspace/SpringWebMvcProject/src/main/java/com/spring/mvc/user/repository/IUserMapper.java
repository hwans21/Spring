package com.spring.mvc.user.repository;

import java.util.Map;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {
	
	//아이디 중복 체크 기능 >> boolean으로 안하고 int로 한 이유 로그인처리까지 활용하기 위해서
	int checkId(String account);
	
	//회원 가입 기능
	void register(UserVO user);
	
	//회원 정보 조회 기능
	UserVO selectOne(String account);
	
	//회웥 탈퇴
	void delete(String account);
	
	//자동 로그인 쿠키값DB저장 처리
	// sql -> update! -> session_id, 유효기간, 누구인지 알려줘야죠.
	void keepLogin(Map<String, Object> datas);
	
	//세션 아이디를 통한 회원 정보 조회 기능
	// 자동 로그인 하고 싶다는 사람한테 뭘만들어 줬죠? -> 쿠키(세션 id)
	// 그리고  그 사람이 나중에 우리 사이트에 방문했다고 칩시다.
	// 당연히 우리 서버에 요청을 보낼거고, 요청과 함께 쿠키도 같이 전달 되겠죠?
	// 우리는 쿠키안에 들은 세션id로 회원정보를 조회해서 마치 이사람이 로그인 중인 것처럼
	// 세션데이터를 만들어 주자는 겁니다.(login이라는 데이터 -> 로그인 중이라는 징표).
	
	UserVO getUserWithSessionId(String sessionId);
	
}

