package com.spring.db.model;

public class BoardVO {

	/*
	 * CREATE TABLE board( board_id NUMBER PRIMARY KEY, board_writer VARCHAR2(30),
	 * board_title VARCHAR2(30), board_content VARCHAR2(1000) );
	 * 
	 * CREATE SEQUENCE board_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 1000
	 * NOCYCLE NOCACHE;
	 */

	private int boardNo;
	private String writer;
	private String title;
	private String content;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardVO [writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}

}
