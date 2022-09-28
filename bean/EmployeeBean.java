package com.masai.bean;

public class EmployeeBean {


	private int complainId;
	private String complainName;
	private String complainDetail;
	private String complainStatus;
	private String complainType;
	private String complainAnswer;
	private int EmployeeId;
	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}






	public EmployeeBean(int complainId,String complainName, String complainDetail, String complainStatus, String complainType,
			String complainAnswer, int EmployeeId) {
		super();
		this.complainId = complainId;
		this.complainName = complainName;
		this.complainDetail = complainDetail;
		this.complainStatus = complainStatus;
		this.complainType = complainType;
		this.complainAnswer = complainAnswer;
		this.EmployeeId = EmployeeId;
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
		return EmployeeId;
	}






	public void setCustomerId(int customerId) {
		this.EmployeeId = customerId;
	}






	@Override
	public String toString() {
		return "EmployeeBean [complainId=" + complainId + ", complainName=" + complainName + ", complainDetail="
				+ complainDetail + ", complainStatus=" + complainStatus + ", complainType=" + complainType
				+ ", complainAnswer=" + complainAnswer + ", EmployeeId=" + EmployeeId + "]";
	}
 
	
	
}
