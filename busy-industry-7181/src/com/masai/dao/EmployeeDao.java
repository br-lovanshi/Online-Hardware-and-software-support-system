package com.masai.dao;

import com.masai.bean.EmployeeBean;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerExecption;

public interface EmployeeDao {

	
	 public int employeeRegistration( EmployeeBean employeeBean) throws EmployeeException;
	 
	 public String EmployeeLogin(String userName, String pass) throws EmployeeException;
	 
	 public String employeeUpdatePass(int id, String userName, String currPass,String newPass) throws EmployeeException;
}
