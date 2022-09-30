package com.masai.dao;

import java.util.ArrayList;

import com.masai.bean.ComplainBean;

public interface ComplainDao {

	
	public ArrayList<ComplainBean> getComplainPerCustomer(int customerId);
	
	
}
