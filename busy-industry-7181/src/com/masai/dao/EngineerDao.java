package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;
import com.masai.bean.EngineerBean;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EngineerExecption;

public interface EngineerDao {

	
	public int addEngineer(EngineerBean bean) throws EngineerExecption;
	
	public ArrayList<EngineerBean> allEngineersList() throws EngineerExecption;
	
	public String removeEngineerByHODViaID(int id) throws EngineerExecption;
	
	public String engineerLogin(String id,String pass) throws EngineerExecption;
	
	
	public String UpdatePassWord(int id, String email, String currPass, String newPass) throws EngineerExecption;
	
	public String UpdateMobileNum(int id, String currMobileN, String newMobileN, String Pass) throws EngineerExecption;

	
	public ArrayList<ComplainBean> getComplainEnggId(int enggId) throws EngineerExecption, ComplainException;
	
	int getAssignedEngg(int complainId) throws EngineerExecption, ComplainException;

	public String getEnggDetails(int enggId)throws EngineerExecption;

	public String updateStatusOfComplain(int complainId,String status) throws EngineerExecption ;//update status by eng;

	int idByEnggMail(String enggMail) throws EngineerExecption;

	public ComplainBean getComplain(int complainId)throws EngineerExecption, ComplainException
	;
	
	
	
	
}
