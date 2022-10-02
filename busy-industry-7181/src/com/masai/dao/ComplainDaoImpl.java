package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.masai.bean.ComplainBean;
import com.masai.bean.EngineerBean;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerExecption;
import com.masai.utility.DBUtil;
import com.mysql.cj.protocol.Resultset;

public class ComplainDaoImpl implements ComplainDao{

	@Override
	public int CreateNewComplain(ComplainBean bean) throws ComplainException {
	

				int id = 0;
				
				try(Connection conn = DBUtil.provideConnection()){
					
			
					
					PreparedStatement ps = 
							conn.prepareCall("insert into complain (complainType,complainStatus,EmployeeId) values (?,?,?)");
					
					
					
					ps.setString(1, bean.getComplainType());
					ps.setString(2, bean.getComplainStatus());
					
					ps.setInt(3, bean.getEmployeeId());
					
					int x = ps.executeUpdate();
					
					if(x>0) {
						
						ResultSet rs  = ps.getGeneratedKeys();
					
						if(rs.next())
						id = rs.getInt(1);
						
					}else throw new ComplainException(" Complain IS wrong");
						
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
					
				}
				
				return id;
			}
	

//	HOD Query
	
	@Override
	public ArrayList<ComplainBean> getAllComplainDetais() throws ComplainException {
		ArrayList<ComplainBean> clist=new ArrayList<ComplainBean>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =conn.prepareStatement("select * from complain");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				ComplainBean cBean= new ComplainBean(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4));
				clist.add(cBean);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ComplainException("Compalins are wrong");
		}
		
		return clist;
	}

//HOD Query
	
	@Override
	public String assignComplainToEngg(int complainId, int enggId) throws ComplainException , EngineerExecption{
		String s = null;
		try (Connection conn = DBUtil.provideConnection()){
//			
			PreparedStatement	ps=conn.prepareStatement("insert into ComplainAssign values( ?,?,?)");
			ps.setInt(1, complainId);
			ps.setInt(2, enggId);
			ps.setString(3, "processing");
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				
				ps=conn.prepareStatement("update complain set complainStatus=? where complainId=?");
				ps.setString(1, "processing");
				ps.setInt(2, complainId);
				int x  = ps.executeUpdate();
				if(x > 0) {
					s = "Assigend taks to Engineer";
				}
			}
			else
				
				{throw new ComplainException("Invalid  ID");
			}
//			throw new EngineerExecption("Invalid Engineer ID");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return s;
	}

	
//	@Override
//	public String assignComplainToEngg(int complainId, int engineerId) {
//		
//		String s = null;
//		
//		
//		try (Connection conn = DBUtil.provideConnection()){
//			
//			PreparedStatement ps =conn.prepareStatement("insert into ComplainAssign values( ?,?,?)");
//			
//			ps.setInt(1,complainId);
//			ps.setInt(2, engineerId);
//			ps.setString(3, "Pendding");
//			
//			int x = ps.executeUpdate();
//			
//			if(x > 0) {
//				 s = "Problem Assigend to the engineer";
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return s;
//	
//		}
	
//	check the status of complain by employee 
	

	@Override
	public String checkComplainStatus(int complainId) throws ComplainException {
		
		String status=null;
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps =conn.prepareStatement("select complainStatus from complain where complainId=?");
			ps.setInt(1, complainId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				status=rs.getString("complainStatus");
			
			else
				throw new ComplainException("Please inter right Details");
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
		return status;
	}

	


//	Employee all Complain History of Employee 

	@Override
	public ArrayList<ComplainBean> getComplainPerEmployee(int employeeID) throws EmployeeException {
		
		ArrayList<ComplainBean> list = new  ArrayList<ComplainBean>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from complain where EmployeeId = ? ");
		
		ps.setInt(1, employeeID);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			ComplainBean complainBean = new ComplainBean(
					
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4));
			
			list.add(complainBean);
			
		}
		
		
			
		}catch(SQLException e ){
			 System.out.println(e.getMessage());
			throw new EmployeeException("Invalid ID");
		}
				
		return list;
	}
	
}
