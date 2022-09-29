package com.masai.bean;

public class EngineerBean {

	
	private int enggId;
	private String enggName;
	private String enggMail;
	private int enggMobile;
	private String enggPassword;
	
	public EngineerBean() {
		
	}
	
	public EngineerBean(int enggId, String enggName, String enggMail, int enggMobile, String enggPassword) {
		super();
		this.enggId = enggId;
		this.enggName = enggName;
		this.enggMail = enggMail;
		this.enggMobile = enggMobile;
		this.enggPassword = enggPassword;
	}
	public int getEnggId() {
		return enggId;
	}
	public void setEnggId(int enggId) {
		this.enggId = enggId;
	}
	public String getEnggName() {
		return enggName;
	}
	public void setEnggName(String enggName) {
		this.enggName = enggName;
	}
	public String getEnggMail() {
		return enggMail;
	}
	public void setEnggMail(String enggMail) {
		this.enggMail = enggMail;
	}
	public int getEnggMobile() {
		return enggMobile;
	}
	public void setEnggMobile(int enggMobile) {
		this.enggMobile = enggMobile;
	}
	public String getEnggPassword() {
		return enggPassword;
	}
	public void setEnggPassword(String enggPassword) {
		this.enggPassword = enggPassword;
	}
	@Override
	public String toString() {
		return "EngineerBean [enggId=" + enggId + ", enggName=" + enggName + ", enggMail=" + enggMail + ", enggMobile="
				+ enggMobile + ", enggPassword=" + enggPassword + "]";
	}

	
	
}
