package org.spring.dto;

import java.sql.Date;

public class BoardDTO {
	private int num;
	private String userid;
	private String email;
	private String subject;
	private String content;
	private int readcount;
	private int replycount;
	private Date regdate;
	public BoardDTO() {
		super();
	}
	public BoardDTO(int num, String userid, String email, String subject, String content, int readcount, int replycount,
			Date regdate) {
		super();
		this.num = num;
		this.userid = userid;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.readcount = readcount;
		this.replycount = replycount;
		this.regdate = regdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "BoradDTO [num=" + num + ", userid=" + userid + ", email=" + email + ", subject=" + subject
				+ ", content=" + content + ", readcount=" + readcount + ", replycount=" + replycount + ", regdate="
				+ regdate + "]";
	}
	
	
}
