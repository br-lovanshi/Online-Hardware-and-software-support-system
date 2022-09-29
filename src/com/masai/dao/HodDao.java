package com.masai.dao;

import com.masai.bean.HodBean;
import com.masai.exceptions.EngineerExecption;

public interface HodDao {

	public String HodLogin(String userName, String pass) throws EngineerExecption;

//	public String HodLogin(HodBean hodBean);
}
