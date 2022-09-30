package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;
import com.masai.exceptions.EngineerExecption;

public interface ComplainDao {

	public int CreateNewComplain(ComplainBean bean) throws EngineerExecption ;
	
	public ArrayList<ComplainBean> getAllComplainDetais() throws EngineerExecption ;
	
//	public String assignComplainToEngg(int complainId,int engineerId);

	public ArrayList<ComplainBean> getComplainPerEmployee(int employeeID) throws EngineerExecption;

	public String checkComplainStatus(int complainId) throws EngineerExecption;

	public String assignComplainToEngg(int complainId, int enggId) throws EngineerExecption;
	
	
}
