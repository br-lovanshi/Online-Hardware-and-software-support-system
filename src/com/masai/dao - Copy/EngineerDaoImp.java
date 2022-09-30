package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.EngineerBean;
import com.masai.utility.DBUtil;

		
public class EngineerDaoImp implements EngineerDao {

	 @Override
	public int addEngineer(EngineerBean bean) {
		int id = 0;
		
		try(Connection conn = DBUtil.provideConnection()){
			
	
			
			PreparedStatement ps = 
					conn.prepareCall("insert into engineer (enggName,enggMail,enggMobile,enggPassword)values (?,?,?,?)");
			
			
			ps.setString(1, bean.getEnggName());
			ps.setString(2, bean.getEnggMail());
			ps.setString(3, bean.getEnggMobile());
			ps.setString(4, bean.getEnggPassword());
			
			int x = ps.executeUpdate();
			if(x>0) {
				
				ResultSet rs  = ps.getGeneratedKeys();
			
				if(rs.next())
				id = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
}
