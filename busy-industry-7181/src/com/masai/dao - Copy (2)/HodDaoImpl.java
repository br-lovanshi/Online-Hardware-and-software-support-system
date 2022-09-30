package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.HodBean;
import com.masai.utility.DBUtil;

public class HodDaoImpl implements HodDao{

	

	public String HodLogin(HodBean hodBean) {
		// TODO Auto-generated method stub
		 String s  = "Can't Login";
		
		 try(Connection conn = DBUtil.provideConnection()){
			  PreparedStatement ps = 
					  conn.prepareStatement("insert into hod values( ?,?)");
			  
			  
			 
			  ps.setString(1, hodBean.getEmail());
			  ps.setString(2, hodBean.getPass());
			  
			  int x = ps.executeUpdate();
			  
			  if(x > 0) {
				  
				  s = "HOD Login SuccessFully";
			  }
			 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		return s;
	}
	
}
