package com.masai.bean;

public class ComplainBean {


	private int complainId;
	private String complainName;
	private String complainDetail;
	private String complainStatus;
	private String complainType;
	private String complainAnswer;
	private int employeeId;
	
	
	public ComplainBean(int complainId, String complainName, String complainDetail, String complainStatus,
			String complainType, String complainAnswer, int employeeId) {
		super();
		this.complainId = complainId;
		this.complainName = complainName;
		this.complainDetail = complainDetail;
		this.complainStatus = complainStatus;
		this.complainType = complainType;
		this.complainAnswer = complainAnswer;
		this.employeeId = employeeId;
	}


	public int getComplainId() {
		return complainId;
	}


	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}


	public String getComplainName() {
		return complainName;
	}


	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}


	public String getComplainDetail() {
		return complainDetail;
	}


	public void setComplainDetail(String complainDetail) {
		this.complainDetail = complainDetail;
	}


	public String getComplainStatus() {
		return complainStatus;
	}


	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}


	public String getComplainType() {
		return complainType;
	}


	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}


	public String getComplainAnswer() {
		return complainAnswer;
	}


	public void setComplainAnswer(String complainAnswer) {
		this.complainAnswer = complainAnswer;
	}


	public int getCustomerId() {
		return employeeId;
	}


	public void setCustomerId(int customerId) {
		this.employeeId = customerId;
	}


	@Override
	public String toString() {
		return "ComplainBean [complainId=" + complainId + ", complainName=" + complainName + ", complainDetail="
				+ complainDetail + ", complainStatus=" + complainStatus + ", complainType=" + complainType
				+ ", complainAnswer=" + complainAnswer + ", customerId=" + employeeId + "]";
	}
	
	
	
	
}
