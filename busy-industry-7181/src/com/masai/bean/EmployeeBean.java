package com.masai.bean;

public class EmployeeBean {


	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeEmail;
	private String EmployeeMobile;
	private String EmployeeCity;
	private String EmployeePass;

	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeBean(int employeeId, String employeeName, String employeeEmail, String employeeMobile,
			String employeeCity, String employeePass) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmployeeEmail = employeeEmail;
		EmployeeMobile = employeeMobile;
		EmployeeCity = employeeCity;
		EmployeePass = employeePass;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return EmployeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}

	public String getEmployeeMobile() {
		return EmployeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		EmployeeMobile = employeeMobile;
	}

	public String getEmployeeCity() {
		return EmployeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		EmployeeCity = employeeCity;
	}

	public String getEmployeePass() {
		return EmployeePass;
	}

	public void setEmployeePass(String employeePass) {
		EmployeePass = employeePass;
	}

	@Override
	public String toString() {
		return "EmployeeBean [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeEmail="
				+ EmployeeEmail + ", EmployeeMobile=" + EmployeeMobile + ", EmployeeCity=" + EmployeeCity
				+ ", EmployeePass=" + EmployeePass + "]";
	}





	
	
}
