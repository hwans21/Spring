package com.spring.myweb.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*
 -- 댓글
CREATE TABLE freereply(
    rno NUMBER(10,0), --댓글번호 (PK)
    bno NUMBER(10,0), --글번호(FK)
    reply VARCHAR2(1000), -- 내용
    reply_id VARCHAR2(50), -- 글쓴이
    reply_pw VARCHAR2(50), --비밀번호
    reply_date DATE DEFAULT SYSDATE, --등록일
    update_date DATE DEFAULT NULL
);

CREATE SEQUENCE freereply_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
    
ALTER TABLE freereply
ADD CONSTRAINT freereply_pk PRIMARY KEY (rno);

ALTER TABLE freereply
ADD CONSTRAINT freereply_fk FOREIGN KEY (bno)
REFERENCES freeboard (bno);
 */
@Getter
@Setter
public class ReplyVO {
	
	private int rno;
	private int bno;
	
	private String reply;
	private String replyId;
	private String replyPw;
	private Timestamp replyDate;
	private Timestamp updateDate;
	

}
