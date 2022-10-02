package com.masai.bean;

public class ComplainBean {


	private int complainId;
	
	
	private String complainType;
	private String complainStatus;
	private int employeeId;

	public ComplainBean(int complainId, String complainType, String complainStatus, int employeeId) {
		super();
		this.complainId = complainId;
		this.complainStatus = complainStatus;
		this.complainType = complainType;
		this.employeeId = employeeId;
	}

	public ComplainBean() {
		super();
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "ComplainBean [complainId=" + complainId + ", complainStatus=" + complainStatus + ", complainType="
				+ complainType + ", employeeId=" + employeeId + "]";
	}
	
	
	
	
}
