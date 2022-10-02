package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.HodBean;
import com.masai.exceptions.EngineerExecption;
import com.masai.utility.DBUtil;

public class HodDaoImpl implements HodDao{

	

	public String HodLogin(String userName, String pass) throws EngineerExecption {
		// TODO Auto-generated method stub
String s = "Can't be Login, please check id and password!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement(" select HodPass from hod where HODUserName =? ");
			
			ps.setString(1, userName);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				String password = rs.getString("HodPass");
				
				if(password.equals(pass))
				s = "HOD Login Successfully!";
			else 
				throw new EngineerExecption("Please Check Id and Pass");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return s;
		
		
	}
	
}
