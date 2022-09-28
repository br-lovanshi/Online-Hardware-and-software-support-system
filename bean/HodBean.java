package com.masai.bean;

public class HodBean 
{
	private String email;
	private String pass;
	public HodBean(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "HodBean [email=" + email + ", pass=" + pass + "]";
	}

	
	
	
}
