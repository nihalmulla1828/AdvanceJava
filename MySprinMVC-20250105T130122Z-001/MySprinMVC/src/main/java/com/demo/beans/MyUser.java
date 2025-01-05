package com.demo.beans;

public class MyUser {
	private String uname;
	private String password;
	private String role;
	public MyUser() {
		super();
	}
	public MyUser(String uname, String passwd, String role) {
		super();
		this.uname = uname;
		this.password = passwd;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MyUser [uname=" + uname + ", passwd=" + password + ", role=" + role + "]";
	}
	

}
