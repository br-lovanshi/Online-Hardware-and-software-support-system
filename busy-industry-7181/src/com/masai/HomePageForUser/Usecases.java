package com.masai.HomePageForUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.ComplainBean;
import com.masai.bean.EmployeeBean;
import com.masai.bean.EngineerBean;
import com.masai.dao.ComplainDao;
import com.masai.dao.ComplainDaoImpl;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImp;
import com.masai.dao.HodDao;
import com.masai.dao.HodDaoImpl;
import com.masai.exceptions.EngineerExecption;


	class Usecases {
	   
//		   static   Scanner sc = new Scanner(System.in);
		  static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//		   String s = sc.readLine();
//		int x =    sc.readLine(); Integer.parseInt(sc.readLine().trim());
		   
		//   HOD Start -----------------------------------------------------
			public boolean HodLogin() throws IOException {
					
				boolean isTrue = false;
			
				
				System.out.println("Enter HOD Email(UserName)");
				String UserName  = sc.readLine();
				System.out.println("Enter HOD Password");
				String Pass = sc.readLine();
				
			
				
				
				HodDao hodDao = new HodDaoImpl();

				
				
				
				String s= null;
				try {
					s = hodDao.HodLogin(UserName, Pass);
				} catch (EngineerExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\n ++++++++++++++++++++++++");
				
				System.out.println(s);
				
				System.out.println(" ++++++++++++++++++++++++ \n");
				
				
				
				if(s.equals("HOD Login Successfully!"))isTrue = true;
				
				return isTrue;
			}
			
			public  void AddEngineerByHOD() throws IOException, EngineerExecption {

				System.out.println("Enter Engineer Name");
				String name = sc.readLine();
				System.out.println("Enter Engineer Email");
				String email = sc.readLine();
				System.out.println("Enter Engineer Mobile");
				int mobile = Integer.parseInt(sc.readLine().trim());
				System.out.println("Enter Engineer PassWord");
				String pass  = sc.readLine();
				
				EngineerBean bean = new EngineerBean(0,name,email,mobile,pass);
				
				EngineerDao engineerDao = new EngineerDaoImp();
				
				int engId = engineerDao.addEngineer(bean);
				
				if(engId>0)
				System.out.println("Your Engineer ID is : " + engId);
				
			}
			
			
		    public  void AllEngineersList() {
				
				EngineerDao engineerDao = new EngineerDaoImp();
				

			ArrayList<EngineerBean> bean = null;
			try {
				bean = engineerDao.allEngineersList();
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(EngineerBean i : bean) {
						System.out.println("------------------------------------------------ \n");
				System.out.println("Engineer id " + i.getEnggId());
				System.out.println("Engineer Name : " + i.getEnggName());
				System.out.println("Engineer Email : " + i.getEnggMail());
				System.out.println("Engineer Mobile : " +i.getEnggMobile());
				System.out.println("Engineer password : " +i.getEnggPassword());
				System.out.println("------------------------------------------------ \n");
			}
			
			}



		    public void RemoveEngineerByHOD() throws Exception, IOException {
			
			
			
			System.out.println("Enter Engineer ID ");
			
			int id =  Integer.parseInt(sc.readLine().trim());
			
			EngineerDao engineerDao = new EngineerDaoImp();
			String s = null;
			try {
				s = engineerDao.removeEngineerByHODViaID(id);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			
			System.out.println(s);
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			
			
			
		}

		    
		    
		    public void AllComplainList() {
		    	
		    	ComplainDao dao = new ComplainDaoImpl();
		    	
		    	
		    	
		    	ArrayList<ComplainBean> list = null;
				try {
					list = dao.getAllComplainDetais();
				} catch (EngineerExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	for(ComplainBean i : list) {
		    		System.out.println("\n ++++++++++++++++++++++++ \n");
		    		System.out.println("Complain ID " +i.getComplainId());

		    		System.out.println("Complain Status " +i.getComplainStatus());

		    		System.out.println("Complain Type " +i.getComplainType());

		    		System.out.println("Employee ID " +i.getEmployeeId());

		    		System.out.println("\n ++++++++++++++++++++++++ \n");
		    		
		    	}
		    }
		    
		 
		    public void assignComplainToEngineer() throws NumberFormatException, IOException {
		    	
		    	System.out.println("Enter Complain ID");
		    	
		    	int cid =  Integer.parseInt(sc.readLine().trim());
		    	System.out.println("Enter Engineer ID");
		    	int eid =    Integer.parseInt(sc.readLine().trim());
		    	
		    	ComplainDao complainDao = new  ComplainDaoImpl();
		    	
		    	String s = null;
		    	
		    	try {
					s = complainDao.assignComplainToEngg(cid, eid);
				} catch (EngineerExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					e.getMessage();
				}
		    	System.out.println("\n ++++++++++++++++++++++++ \n");
		    	System.out.println(" " + s);
		    	System.out.println("\n ++++++++++++++++++++++++ \n");
		    }
		    
		    
		    
//		    Engineer start ---------------------------------------------------------

			public boolean EngineerLogin() throws IOException {
			
			
			boolean flag = false;
			
			
			System.out.println("Enter Engineer Email(UserName)");
			
			String name =   sc.readLine();
			
			System.out.println("Enter Engineer Pass");
			
			
			String pass =   sc.readLine(); 
			
			
			EngineerDao  engineerDao = new EngineerDaoImp();
			
			String s = null;
			
			try {
				s = engineerDao.engineerLogin(name, pass);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n ++++++++++++++++++++++++ \n");
			System.out.println(s);
			System.out.println("\n ++++++++++++++++++++++++ \n");
			if(s.equals("Engineer Login Successfully!")) flag = true;
			
			
			return flag;
		}

			  public void UpdateStatusByEngineer() throws NumberFormatException, IOException {
			    	
			    	System.out.println("Enter Complain ID");
			    	
			    	int cid =   Integer.parseInt(sc.readLine().trim());
			    	
			    
			    	System.out.println("Enter complain new status");
			    	String status =  sc.readLine();
			    	
			    	EngineerDao engineerDao = new EngineerDaoImp();
			    	
			    	
			    	String s = null;
					try {
						s = engineerDao.updateStatusOfComplain(cid, status);
						
					} catch (EngineerExecption e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	System.out.println("\n ++++++++++++++++++++++++ \n");
			    	System.out.println(s);
			    	System.out.println("\n ++++++++++++++++++++++++ \n");
			    }

			public void getComplainAssigenToEngineer() throws NumberFormatException, IOException {
				
				System.out.println("Enter Engineer ID ");
				int eid =   Integer.parseInt(sc.readLine().trim());
				
				EngineerDao engineerDao = new EngineerDaoImp();
				
				
			ArrayList<ComplainBean> list = null;
			try {
				list = engineerDao.getComplainEnggId(eid);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				for(ComplainBean i : list) {
					System.out.println("\n ++++++++++++++++++++++++ \n");
					System.out.println("Complain ID " +i.getComplainId());

		    		System.out.println("Complain Status " +i.getComplainStatus());

		    		System.out.println("Complain Type " +i.getComplainType());

		    		System.out.println("Employee ID " +i.getEmployeeId());

		    		System.out.println("\n ++++++++++++++++++++++++ \n");
		    		
				}
				
				
			}
			
			
			
			
			public  void ENgineerUpdateMobileNumber() throws IOException {
				
				
				
			System.out.println("Enter the Engineer Id ");
			
			int id =  Integer.parseInt(sc.readLine().trim());
			
			
			System.out.println("Enter Current Mobile Number ");
			String currNumber =   sc.readLine();
			
			System.out.println("Enter New Mobile Number");
			int num =    Integer.parseInt(sc.readLine().trim());
			
			String newNumber  = String.valueOf(num); 
			System.out.println("Enter Password ");
			String pass =   sc.readLine();

			EngineerDao  dao = new EngineerDaoImp();
			String s = "Try Again Letter!";
			 try {
				 s = dao.UpdateMobileNum(id, currNumber, newNumber, pass);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("\n ++++++++++++++++++++++++ \n"); 
			 System.out.println(s);
			 System.out.println("\n ++++++++++++++++++++++++ \n");
		}

			public  void EngineerUpdatePassword() throws IOException {
				
				
				
				System.out.println("Enter the Engineer Id ");
				
				int id =  Integer.parseInt(sc.readLine().trim());
				
				System.out.println("Enter Email");
				String email =   sc.readLine().trim();
				
				System.out.println("Enter Current Password ");
				String currPass = sc.readLine().trim();
				
				System.out.println("Enter New Password");
				String newPass =sc.readLine().trim();
				
				EngineerDao dao = new EngineerDaoImp();
				
				String   s = "Please Try Again Letter";
				
				try {
					s = dao.UpdatePassWord(id, email, currPass, newPass);
				} catch (EngineerExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\n ++++++++++++++++++++++++ \n");
				System.out.println(s);
				System.out.println("\n ++++++++++++++++++++++++ \n");
				}
			
			
			
			
//			Employee ===============================================================================================  
			
//			sign up 
		public  void EmployeeRegistration() throws NumberFormatException, IOException {
				

//			  sc.readLine(); Integer.parseInt(sc.readLine().trim());
				System.out.println("Employee Name");
				String EmployeeName =sc.readLine().trim();
			
				System.out.println("Employee Email");
				
				String email = sc.readLine().trim();

				System.out.println("Employee Mobile Number");
				
				int num1 = Integer.parseInt(sc.readLine().trim());
				
				String mobile = String.valueOf(num1);
				
				System.out.println("Employee City");
				
				String city = sc.readLine().trim();
				
				System.out.println("Employee Password");
				String pass = sc.readLine().trim();
				
				EmployeeBean employeeBean = new EmployeeBean(0, EmployeeName, email, mobile, city, pass);
					
			
				
				EmployeeDao dao = new EmployeeDaoImpl();
				
				 int id = 0;
				try {
					id = dao.employeeRegistration(employeeBean);
				} catch (EngineerExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(id>0) {
				System.out.println("\n ++++++++++++++++++++++++ \n");
				System.out.println("Employee Id :- " +id);
				System.out.println("\n ++++++++++++++++++++++++ \n");
				
				}
						
			
				
			}


		//login  

		public boolean EmployeeLogin() throws IOException {
			
			boolean flag = false;
			
			System.out.println("Enter Employee userName(Email)");
			String userName = sc.readLine().trim(); 
			
			System.out.println("Enter Employee Password");
			
			String pass = sc.readLine(); 
			
			EmployeeDao employeeDao = new  EmployeeDaoImpl();
			
			String s = null;
			
			try {
				s = employeeDao.EmployeeLogin(userName, pass);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			System.out.println(s);
			System.out.println("\n ++++++++++++++++++++++++ \n");
			
			
			if(s.equals("Employee Login Successfully!")) 
			{ 
				flag = true;
			}
			
			return flag;
		}





		public  void EmployeeUpdatePassword() throws IOException {
			
			
			
			System.out.println("Enter the Employee Id ");
			
			int id =  Integer.parseInt(sc.readLine().trim());
			
			System.out.println("Enter UserName(Email)");
			String email = sc.readLine(); 
			
			System.out.println("Enter Current Password ");
			String currPass =sc.readLine(); 
			
			System.out.println("Enter New Password");
			String newPass = sc.readLine();
			
			EmployeeDao dao = new EmployeeDaoImpl();
			
			String   s = "Please Try Again Letter";
			
			try {
				s = dao.employeeUpdatePass(id, email, currPass, newPass);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			System.out.println(s);
			System.out.println("\n ++++++++++++++++++++++++ \n");
			}


		//Complain ----------------------------------------------------------------------

		public void CreateComplain() throws IOException {
			
			
			System.out.println("Enter complain Type (Software/HardWare");
			String Ctype = sc.readLine();
			System.out.println("Enter complain Status(enter new)");
			String Cstatus = sc.readLine(); 
			
			
			System.out.println("Enter Employee ID");
			int EmployeeId  =  Integer.parseInt(sc.readLine().trim());
			
			ComplainBean complainBean = new ComplainBean(0,Cstatus, Ctype,  EmployeeId);
			
			ComplainDao complainDao = new ComplainDaoImpl();
			
			int id = 0;
			try {
				id = complainDao.CreateNewComplain(complainBean);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(id>0) {
				System.out.println("\n ++++++++++++++++++++++++ \n");
				System.out.println("Your Complain ID : "+ id);
				System.out.println("\n ++++++++++++++++++++++++ \n");
			}
			
		}



		public void AssignedEngineer() throws NumberFormatException, IOException {
			
			
			System.out.println("Enter Complain ID ");
			
			int cid = Integer.parseInt(sc.readLine().trim());
			
			EngineerDao  engineerDao = new EngineerDaoImp();
			
			int EngineerID = 0;
			try {
				EngineerID = engineerDao.getAssignedEngg(cid);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String EngineerName = null;
			try {
				EngineerName = engineerDao.getEnggDetails(EngineerID);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			System.out.println("Your assingen Engineer Name is :" + EngineerName);
			System.out.println("\n ++++++++++++++++++++++++ \n");
			
		}


		public void CheckStatusOfProblem() throws NumberFormatException, IOException {
			
			System.out.println("Enter Complain ID");
			
			int cid = Integer.parseInt(sc.readLine().trim());
			
			ComplainDao complainDao = new ComplainDaoImpl();
			
			String s = "Please enter correct Complain ID";
			
			try {
				s = complainDao.checkComplainStatus(cid);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\n ++++++++++++++++++++++++ \n");
			System.out.println(s);
			System.out.println("\n ++++++++++++++++++++++++ \n");
		}




		public void AllComplianHistoryList() throws NumberFormatException, IOException {
			
			System.out.println("Enter Employee Id");
			
			int eid =  Integer.parseInt(sc.readLine().trim());
			
			ComplainDao complainDao = new ComplainDaoImpl();
			
			ArrayList<ComplainBean> list = null;
			try {
				list = complainDao.getComplainPerEmployee(eid);
			} catch (EngineerExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(ComplainBean i : list) {
				System.out.println("\n ++++++++++++++++++++++++ \n");
				
				System.out.println("Complain ID :" + i.getComplainId());
				
				System.out.println("Complain Status : " + i.getComplainStatus());
				
				System.out.println("Complain Type : " + i.getComplainType());
				
				System.out.println("Employee ID : " + i.getEmployeeId());
				
				System.out.println("\n ++++++++++++++++++++++++ \n");
			}
			
		}

		
	
	
	}

                 

