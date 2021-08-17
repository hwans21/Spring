package com.spring.myweb.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

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
}
