package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerExecption;

public interface ComplainDao {

	public int CreateNewComplain(ComplainBean bean) throws ComplainException ;
	
	public ArrayList<ComplainBean> getAllComplainDetais() throws ComplainException ;
	
//	public String assignComplainToEngg(int complainId,int engineerId);

	public ArrayList<ComplainBean> getComplainPerEmployee(int employeeID) throws ComplainException, EmployeeException;

	public String checkComplainStatus(int complainId) throws EngineerExecption, ComplainException;

	public String assignComplainToEngg(int complainId, int enggId) throws ComplainException, EngineerExecption;
	
	
}
