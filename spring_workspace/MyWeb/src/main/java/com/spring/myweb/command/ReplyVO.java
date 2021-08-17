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

ALTER TABLE freereply
DROP CONSTRAINT freereply_fk;


# 1. ON DELETE CASCADE:
참조되는 부모 테이블의 행에 대한 DELETE를 허용합니다.
즉, fk를 통한 자식테이블의 참조가 있다 하더라도, 부모 테이블의 데이터가 삭제되면
연계된 자식 테이블의 데이터까지 모두 삭제가 진행됩니다.
테이블의 구조가 복잡하다면 (하나의 테이블에 여러테이블이 연계가 되어있는 경우)
CASCADE 사용을 고려해 보셔야 합니다.

# 2. ON DELETE SET NULL;
부모테이블의 값이 삭제된다면 해당 값을 참조하던 자식 테이블의 값을 null로 설정하겠다.
fk로 설정된 bno의 값을 null로 설정하겠다.

FOREIGN KEY를 설정하면, 참조 무결성 규칙이 발동됩니다.
참조 무결성 -> 참조 관계에 있는 두 테이블의 데이터는 항상 일관된 값을 가져야 한다.
데이터베이스 구조가 많이 복잡하지 않다면 논리적 모델링까지는 FK를 설정하지만
물리적 모델링의 경우에는 FK를 생략하는 경우도 많습니다.


ALTER TABLE freereply
ADD CONSTRAINT freereply_fk FOREIGN KEY (bno)
REFERENCES freeboard (bno) 
1. ON DELETE CASCADE;
2. ON DELETE SET NULL;


조작어는 commit을 해줘야 하지만
alter같은경우는 할 필요 읎음

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
