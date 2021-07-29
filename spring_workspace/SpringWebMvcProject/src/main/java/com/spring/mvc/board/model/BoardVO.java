package com.spring.mvc.board.model;

import java.sql.Timestamp;

/*
 -- 게시판 테이블 생성
CREATE TABLE mvc_board(
    board_no NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(300) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    reg_date DATE DEFAULT SYSDATE,
    view_cnt NUMBER DEFAULT 0
);


-- board_no에 대한 시퀀스 설정
CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
    
    lombok 설치(getter setter메서드와 생성자 빠르게 생성)
    https://projectlombok.org/download에서 jar파일 다운 후 
    sts실행 폴더로 옮겨줌(C:\Program Files (x86)\sts-bundle\sts-3.9.15.RELEASE)
    그리고 실행 (안될시 java -jar lombok.jar)-> (못찾을 시) Specify location 클릭후 sts.exe 클릭
    
 */

public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Timestamp regDate;
	private int viewCnt;
	
	
}
