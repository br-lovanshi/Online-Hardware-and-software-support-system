package com.masai.dao;

import com.masai.bean.EmployeeBean;
import com.masai.exceptions.EngineerExecption;

public interface EmployeeDao {

	
	 public int employeeRegistration( EmployeeBean employeeBean);
	 
	 public String EmployeeLogin(String userName, String pass) throws EngineerExecption;
	 
	 public String employeeUpdatePass(int id, String userName, String currPass,String newPass);
}
