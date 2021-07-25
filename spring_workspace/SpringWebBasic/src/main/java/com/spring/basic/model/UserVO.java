package com.spring.basic.model;

import java.util.List;

public class UserVO {
	
//	멤버변수명이랑 파라미터 변수명이랑 같아야함
	private String userId;
	private String userPw;
	private String userName;
	private List<String> hobby;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
		
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", hobby=" + hobby + "]";
	}
	
	
	
	
}
