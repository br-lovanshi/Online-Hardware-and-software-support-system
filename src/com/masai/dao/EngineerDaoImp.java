package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.ComplainBean;
import com.masai.bean.EngineerBean;
import com.masai.exceptions.EngineerExecption;
import com.masai.utility.DBUtil;
import com.mysql.cj.xdevapi.Result;

		
public class EngineerDaoImp implements EngineerDao {
	

	 @Override
	public int addEngineer(EngineerBean bean) {

		int id = 0;
		
		try(Connection conn = DBUtil.provideConnection()){
			
	
			
			PreparedStatement ps = 
					conn.prepareCall("insert into engineer (enggName,enggMail,enggMobile,enggPassword)values (?,?,?,?)");
			
			
			ps.setString(1, bean.getEnggName());
			ps.setString(2, bean.getEnggMail());
			ps.setInt(3, bean.getEnggMobile());
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

	 
	 
	@Override
	public ArrayList<EngineerBean> allEngineersList() {
		
		ArrayList<EngineerBean> list = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection() ){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from engineer");
			

			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String mobile = rs.getString(4);
				String pass  = rs.getString(5);
				int intmobile = Integer.parseInt(mobile);
				EngineerBean bean = new EngineerBean(id,name,email,intmobile,pass);
				
				list.add(bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	
	
	@Override
	public String removeEngineerByHODViaID(int id) {
		String s = "Can't be remove!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from engineer where enggid = ?");
			
			ps.setInt(1, id);
			int x = ps.executeUpdate();
			
			if(x>0) 
				s = "Engineer removed Successfully";
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return s;
	}



	@Override
	public String engineerLogin(String id, String pass) throws EngineerExecption {
		
		String s = "Can't be Login, please check id and password!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement(" select enggPassword from engineer where enggMail =? ");
			
			ps.setString(1, id);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				String password = rs.getString("enggPassword");
				
				if(password.equals(pass))
				s = "Engineer Login Successfully!";
			else 
				throw new EngineerExecption("Please Check Id and Pass");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}


	
	
	@Override
	public int idByEnggMail(String enggMail) {
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement	ps=conn.prepareStatement("select enggId from engg where enggMail=?");
			ps.setString(1, enggMail);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	
	
	@Override
	public String assignComplainToEngg(int complainId, String enggMail) {
		String msg =null;
		try(Connection conn = DBUtil.provideConnection()) {
			
			int id=idByEnggMail(enggMail);
			
			PreparedStatement ps1=conn.prepareStatement("insert into ComplainAssign values(?,?)");
			ps1.setInt(1, complainId );
			ps1.setInt(2, id);
			
			int r = ps1.executeUpdate();
			
			ps1=conn.prepareStatement("update complain set complainStatus=\"Processing\" where complainId=?");
			ps1.setInt(1, complainId);
			
			int s = ps1.executeUpdate();
			
			if(r>0 && s>0)
				
				msg = "Task is Assigend to Engineer";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}


	


	
	@Override
	public String UpdatePassWord(int id, String email, String currPass, String newPass) throws EngineerExecption {
		String s = "Unabel to Upadate Password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement(" update engineer set enggpassword =? where enggId =  ? and enggpassword = ? and enggMail = ?");
		
			ps.setString(1, newPass);
			ps.setInt(2, id);
			ps.setString(3, currPass);
			ps.setString(4, email);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				s = "Password change successfully";
			}
			else throw new EngineerExecption("Please Enter Curr Pass,id,mail Correctly");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}



	@Override
	public String UpdateMobileNum(int id, String currMobileN, String newMobileN, String pass) throws EngineerExecption {
		
String s = "Unable to Upadate Mobile Number";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("update engineer set enggMobile =? where enggId =  ? and enggpassword = ? and enggMobile = ?");
		
			
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				
//				String mobile = rs.getString("enggMobile");
//				if(mobile.equals(newMobileN))
//				s = "Current and New Mobile Number is Same";
//			}else {
			
			
			ps.setString(1, newMobileN);
			ps.setInt(2, id);
			ps.setString(3, pass);
			ps.setString(4, currMobileN);
			
			
			int x = ps.executeUpdate();
			if(x>0) {
				s = "Mobile Number change successfully";
			}
			
			else throw new EngineerExecption("Please Enter Curr Mobile,id,pass Correctly");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		
	}
	
	
	
	
	
	
	
//	employee query 
	
	@Override
	public int getAssignedEngg(int complainId) {
			int EngineerId = 0;
		
try(Connection conn = DBUtil.provideConnection()){
		
			PreparedStatement ps = conn.prepareStatement("select engId from ComplainAssign where cid=?");
			ps.setInt(1, complainId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				EngineerId =  rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EngineerId;
	}

	
	@Override
	public String getEnggDetails(int enggId) {
		
		String EngineerName = null;

		try (Connection conn =  DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select enggName  from engineer where enggId=?");

			ps.setInt(1, enggId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				EngineerName = rs.getString("enggName");
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return EngineerName;
	}



	
	
	
	
	
	
//	Engineer Query 
	
	
	@Override
	public ComplainBean getComplain(int complainId) {
		ComplainBean cBean = null;
		

		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =conn.prepareStatement("select * from complain where complainId=?");
			ps.setInt(1, complainId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				cBean = new ComplainBean(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cBean;
	}

	
	@Override
	public ArrayList<ComplainBean> getComplainEnggId(int enggId) {
		// TODO Auto-generated method stub
		ArrayList<ComplainBean> list = new  ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select cid from ComplainAssign where engId = ?");
			ps.setInt(1, enggId);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				int complainId = rs.getInt(1);
				
				ComplainBean complainBean = getComplain(complainId);
				
				list.add(complainBean);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return list;
	}
	
	
	
	
	
	
	
}
