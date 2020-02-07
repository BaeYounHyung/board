package org.spring.dto;

import java.sql.Date;

public class FileDTO {
	private int fnum;
	private int num;
	private String filename;
	private Date regdate;
	public FileDTO() {
		super();
	}
	public FileDTO(int fnum, int num, String filename, Date regdate) {
		super();
		this.fnum = fnum;
		this.num = num;
		this.filename = filename;
		this.regdate = regdate;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "FileDTO [fnum=" + fnum + ", num=" + num + ", filename=" + filename + ", regdate=" + regdate + "]";
	}
	
	
}
