package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.EmployeeBean;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerExecption;
import com.masai.utility.DBUtil;
import com.mysql.cj.xdevapi.Result;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int employeeRegistration(EmployeeBean employeeBean) throws EmployeeException {
		
		int id = 0;
		
		
		try(Connection conn = DBUtil.provideConnection() ){
			
			
			PreparedStatement ps =
					conn.prepareCall("insert into employee ( employeeName,employeeUserName,EmployeeMobile,EmployeeCity,EmployeePass) values (?,?,?,?,?)");
		
			ps.setString(1, employeeBean.getEmployeeName());
			ps.setString(2, employeeBean.getEmployeeEmail());
			ps.setString(3, employeeBean.getEmployeeMobile());
			ps.setString(4, employeeBean.getEmployeeCity());
			ps.setString(5, employeeBean.getEmployeePass());
		
int x = ps.executeUpdate();
			
			if(x>0) {
				
				ResultSet rs  = ps.getGeneratedKeys();
			
				if(rs.next())
				id = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
		System.out.println(e.getMessage());
			throw new EmployeeException("Please check Deatail");
		}
		
		return id;
			}

	
	
	
	@Override
	public String EmployeeLogin(String userName, String pass) throws EmployeeException {
		
		String s = "Employee id and pass is Wrong...";
		
		try(Connection conn =  DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement(" select employeePass from employee where employeeUserName = ?");
			
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				String password = rs.getString("employeePass");
				
				if(password.equals(pass))
				s = "Employee Login Successfully!";
			else 
				throw new EmployeeException("Please Check Id and Password");
			}
			
			
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		
		
		return s;
	}

	
	
	
	
	@Override
	
	public String employeeUpdatePass(int id, String userName, String currPass, String newPass) throws EmployeeException {
			
			
			String s = "Unable to Update";
			
			try(Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps =
						conn.prepareStatement(" update  employee set employeepass = ? where employeeId = ? and employeeUserName = ? and employeepass = ?" );
			
			ps.setString(1, newPass);
			ps.setInt(2, id);
			ps.setString(3, userName);
			ps.setString(4,currPass);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				
				s = "Password reset Successfully";
			}
			else
				throw new EmployeeException("Please Check Deatails");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}

		return s;
	}





	
	
	
	
}
