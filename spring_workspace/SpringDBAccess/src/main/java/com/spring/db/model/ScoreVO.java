package com.spring.db.model;


/*
 --user생성 및 권한주기
 CREATE USER spring IDENTIFIED BY spring;
GRANT CONNECT, RESOURCE TO spring;
GRANT CREATE SESSION TO spring;

ALTER USER spring DEFAULT TABLESPACE users
QUOTA UNLIMITED ON users;
 
 -- 점수 테이블 생성
CREATE TABLE scores(
    stu_id NUMBER PRIMARY KEY,
    stu_name VARCHAR2(30) NOT NULL,
    kor NUMBER DEFAULT 0,
    eng NUMBER DEFAULT 0,
    math NUMBER DEFAULT 0,
    total NUMBER DEFAULT 0,
    average NUMBER(5,2)
);

CREATE SEQUENCE id_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
 */

public class ScoreVO {
	private int stuId;

	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average;
	
@Override
	public String toString() {
		return "ScoreVO [stuName=" + stuName + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", average=" + average + "]";
	}

public int getStuId() {
	return stuId;
}

public void setStuId(int stuId) {
	this.stuId = stuId;
}

public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	//	총점, 평균을 구하는 메서드
	public void calcData() {
		this.total = this.kor+this.eng+this.math;
		this.average = Math.round((this.total/3.0)*100)/100.0;
	}
}
