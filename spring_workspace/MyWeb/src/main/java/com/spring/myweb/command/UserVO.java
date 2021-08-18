package com.spring.myweb.command;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE users(
    userId VARCHAR2(50),
    userPw VARCHAR2(50) NOT NULL,
    userName VARCHAR2(50) NOT NULL,
    userPhone1 VARCHAR2(50),
    userPhone2 VARCHAR2(50),
    userEmail1 VARCHAR2(50),
    userEmail2 VARCHAR2(50),
    addrBasic VARCHAR2(300),
    addrDetail VARCHAR2(300),
    addrZipNum VARCHAR2(50),
    regDate DATE DEFAULT sysdate
);

ALTER TABLE users
ADD CONSTRAINT userid_pk PRIMARY KEY(userId);
 */
@Getter
@Setter
@ToString
public class UserVO {
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone1;
	private String userPhone2;
	private String userEmail1;
	private String userEmail2;
	private String addrBasic;
	private String addrDetail;
	private String addrZipNum;
	private Timestamp regDate;
	
	
	// 한 명의 회원은 여러개의 글을 작성할 수 있습니다.
	// 마이페이지에서는 특정회원이 작성한 글 목록을 나타내야 합니다.
	// 회원 정보와 글 목록은 서로 다른 테이블로 이루어져 있고, 마이페이지에서는
	// 해당 정보를 한 번의 DB연동으로 가져올 수 있도록 하기 위해서
	// JOIN 문법으로 테이블을 합친 후 원하는 컬럼을 선택해서 가져올 예정입니다.
	
	// 1이 UserVO이기 때문에 UserVO 안에 N의 값을 뜻하는 
	// FreeBoardVO 객체의 모음을 저장할 수 있는 List를 선언
	// 1:N관계의 테이블을 list형태로 선언
	private List<FreeBoardVO> userBoardList;
	
}
