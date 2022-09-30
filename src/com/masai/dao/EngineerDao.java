package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;
import com.masai.bean.EngineerBean;
import com.masai.exceptions.EngineerExecption;

public interface EngineerDao {

	
	public int addEngineer(EngineerBean bean);
	
	public ArrayList<EngineerBean> allEngineersList();
	
	public String removeEngineerByHODViaID(int id) throws EngineerExecption;
	
	public String engineerLogin(String id,String pass) throws EngineerExecption;
	
	
	public String UpdatePassWord(int id, String email, String currPass, String newPass) throws EngineerExecption;
	
	public String UpdateMobileNum(int id, String currMobileN, String newMobileN, String Pass) throws EngineerExecption;

	
	public ArrayList<ComplainBean> getComplainEnggId(int enggId);
	
	int getAssignedEngg(int complainId);

	public String getEnggDetails(int enggId);

	public String assignComplainToEngg(int complainId, String enggMail);

	int idByEnggMail(String enggMail);

	public ComplainBean getComplain(int complainId);
	
	
	
	
}
