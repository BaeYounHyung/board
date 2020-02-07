package org.spring.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyDTO {
	private int rnum;
	private int num;
	private String userid;
	private String content;
	@JsonFormat(pattern="YYYY-MM-dd")
	private Date regdate;
	public ReplyDTO() {
		super();
	}
	public ReplyDTO(int rnum, int num, String userid, String content, Date regdate) {
		super();
		this.rnum = rnum;
		this.num = num;
		this.userid = userid;
		this.content = content;
		this.regdate = regdate;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rnum=" + rnum + ", num=" + num + ", userid=" + userid + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
	
}
