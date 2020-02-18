package com.pgm.bbs.dto;

import java.util.Date;

public class RepleVO {
	private int rno;
	private String content;
	private String writer;
	private Date regdate;
	private int bno;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "RepleVO [rno=" + rno + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate + ", bno="
				+ bno + "]";
	}
}
