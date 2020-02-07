package org.spring.dto;

import java.sql.Date;

public class loginDTO {
	private String id;
	private String password;
	private String name;
	private String email; 
	private String photo;
	private Date regdate; 
	public loginDTO() {
		super();
	}
	public loginDTO(String id, String password, String name, String email, String photo, Date regdate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "loginDTO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", photo="
				+ photo + ", regdate=" + regdate + "]";
	}
	
	
	
	
}
