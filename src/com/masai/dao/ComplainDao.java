package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;

public interface ComplainDao {

	public int CreateNewComplain(ComplainBean bean) ;
	
	public ArrayList<ComplainBean> getAllComplainDetais() ;
	
//	public String assignComplainToEngg(int complainId,int engineerId);

	public ArrayList<ComplainBean> getComplainPerEmployee(int employeeID);

	public String checkComplainStatus(int complainId);

	public String assignComplainToEngg(int complainId, int enggId);
	
	
}
