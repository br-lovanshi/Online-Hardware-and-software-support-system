package com.masai.HomePageForUser;

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.ComplainBean;
import com.masai.bean.EmployeeBean;
import com.masai.bean.EngineerBean;
import com.masai.bean.HodBean;
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
	
   static   Scanner sc = new Scanner(System.in);
   
   
   
//   HOD Start -----------------------------------------------------
	public boolean HodLogin() {
			
		boolean isTrue = false;
	
		
		System.out.println("Enter HOD Email(UserName)");
		String UserName  = sc.next();
		System.out.println("Enter HOD Password");
		String Pass = sc.next();
		
	
		
		HodDao hodDao = new HodDaoImpl();
		
		String s= null;
		try {
			s = hodDao.HodLogin(UserName, Pass);
		} catch (EngineerExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
		
		if(s.equals("HOD Login Successfully!"))isTrue = true;
		
		return isTrue;
	}
	
	public  void AddEngineerByHOD() {

		System.out.println("Enter Engineer Name");
		String name = sc.next();
		System.out.println("Enter Engineer Email");
		String email = sc.next();
		System.out.println("Enter Engineer Mobile");
		int mobile = sc.nextInt();
		System.out.println("Enter Engineer PassWord");
		String pass  = sc.next();
		
		EngineerBean bean = new EngineerBean(0,name,email,mobile,pass);
		
		EngineerDao engineerDao = new EngineerDaoImp();
		
		int engId = engineerDao.addEngineer(bean);
		
		if(engId>0)
		System.out.println("Your Engineer ID is : " + engId);
		
	}
	
	
    public  void AllEngineersList() {
		
		EngineerDao engineerDao = new EngineerDaoImp();
		

	ArrayList<EngineerBean> bean = engineerDao.allEngineersList();
	
	for(EngineerBean i : bean) {
		System.out.println("Engineer id " + i.getEnggId());
		System.out.println("Engineer Name : " + i.getEnggName());
		System.out.println("Engineer Email : " + i.getEnggMail());
		System.out.println("Engineer Mobile : " +i.getEnggMobile());
		System.out.println("Engineer password : " +i.getEnggPassword());
		System.out.println("------------------------------------------------");
	}
	
	}



    public void RemoveEngineerByHOD() {
	
	
	
	System.out.println("Enter Engineer ID ");
	
	int id = sc.nextInt();
	
	EngineerDao engineerDao = new EngineerDaoImp();
	String s = null;
	try {
		s = engineerDao.removeEngineerByHODViaID(id);
	} catch (EngineerExecption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(s);
	
	if(s.equals("Engineer removed Successfully"));
	
	
}

    
    
    public void AllComplainList() {
    	
    	ComplainDao dao = new ComplainDaoImpl();
    	
    	
    	
    	ArrayList<ComplainBean> list = dao.getAllComplainDetais();
    	
    	for(ComplainBean i : list) {
    		
    		System.out.println("Complain ID " +i.getComplainId());

    		System.out.println("Complain Status " +i.getComplainStatus());

    		System.out.println("Complain Type " +i.getComplainType());

    		System.out.println("Employee ID " +i.getEmployeeId());

    		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    		
    	}
    }
    
 
    public void assignComplainToEngineer() {
    	System.out.println("Enter Complain ID");
    	
    	int cid = sc.nextInt();
    	System.out.println("Enter Engineer ID");
    	int eid = sc.nextInt();
    	
    	ComplainDao complainDao = new  ComplainDaoImpl();
    	
    	String s = null;
    	
    	s = complainDao.assignComplainToEngg(cid, eid);
    	
    	System.out.println(s);
    	
    }
    
    
    
//    Engineer start ---------------------------------------------------------

	public boolean EngineerLogin() {
	
	
	boolean flag = false;
	
	
	System.out.println("Enter Engineer Email(UserName)");
	
	String name = sc.next();
	
	System.out.println("Enter Engineer Pass");
	
	
	String pass = sc.next();
	
	
	EngineerDao  engineerDao = new EngineerDaoImp();
	
	String s = null;
	
	try {
		s = engineerDao.engineerLogin(name, pass);
	} catch (EngineerExecption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(s);
	
	if(s.equals("Engineer Login Successfully!")) flag = true;
	
	
	return flag;
}

	  public void UpdateStatusByEngineer() {
	    	
	    	System.out.println("Enter Complain ID");
	    	
	    	int cid = sc.nextInt();
	    	System.out.println("Enter Engineer UserName");
	    	String email = sc.next();
	    	
	    	EngineerDao engineerDao = new EngineerDaoImp();
	    	
	    	
	    	String s = engineerDao.assignComplainToEngg(cid, email);
	    	System.out.println(s);
	    }

	public void getComplainAssigenToEngineer() {
		
		System.out.println("Enter Engineer ID ");
		int eid = sc.nextInt();
		
		EngineerDao engineerDao = new EngineerDaoImp();
		
		
	ArrayList<ComplainBean> list = 	engineerDao.getComplainEnggId(eid);
		
		for(ComplainBean i : list) {
			
			System.out.println("Complain ID " +i.getComplainId());

    		System.out.println("Complain Status " +i.getComplainStatus());

    		System.out.println("Complain Type " +i.getComplainType());

    		System.out.println("Employee ID " +i.getEmployeeId());

    		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    		
		}
		
		
	}
	
	
	
	
	public  void ENgineerUpdateMobileNumber() {
		
		Scanner sc  = new Scanner(System.in);
		
	System.out.println("Enter the Engineer Id ");
	
	int id = sc.nextInt();
	
	
	System.out.println("Enter Current Mobile Number ");
	String currNumber = sc.next();
	
	System.out.println("Enter New Mobile Number");
	String newNumber = sc.next();
	
	System.out.println("Enter Password ");
	String pass = sc.next();

	EngineerDao  dao = new EngineerDaoImp();
	String s = "Try Again Letter!";
	 try {
		 s = dao.UpdateMobileNum(id, currNumber, newNumber, pass);
	} catch (EngineerExecption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 System.out.println(s);

}

	public  void EngineerUpdatePassword() {
		
		
		
		System.out.println("Enter the Engineer Id ");
		
		int id = sc.nextInt();
		
		System.out.println("Enter Email");
		String email = sc.next().trim();
		
		System.out.println("Enter Current Password ");
		String currPass = sc.next().trim();
		
		System.out.println("Enter New Password");
		String newPass = sc.next().trim();
		
		EngineerDao dao = new EngineerDaoImp();
		
		String   s = "Please Try Again Letter";
		
		try {
			s = dao.UpdatePassWord(id, email, currPass, newPass);
		} catch (EngineerExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
			
		}
	
	
	
	
//	Employee ===============================================================================================  
	
//	sign up 
public  void EmployeeRegistration() {
		

		
		System.out.println("Employee Name");
		String EmployeeName = sc.next().trim();
	
		System.out.println("Employee Email");
		
		String email = sc.next().trim();

		System.out.println("Employee Mobile Number");
		
		int mobile = sc.nextInt();
		
		System.out.println("Employee City (optional)");
		
		String city = sc.next().trim();
		
		System.out.println("Employee Password");
		String pass = sc.next().trim();
		
		EmployeeBean employeeBean = new EmployeeBean(0, EmployeeName, email, mobile, city, pass);
			
	
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		 int id = dao.employeeRegistration(employeeBean);
		
		if(id>0) {
		System.out.println("Employee Id :- " +id);
		
		
		}
				
	
		
	}


//login  

public boolean EmployeeLogin() {
	
	boolean flag = false;
	
	System.out.println("Enter Employee userName(Email)");
	String userName = sc.next().trim();
	
	System.out.println("Enter Employee Password");
	
	String pass = sc.next().trim();
	
	EmployeeDao employeeDao = new  EmployeeDaoImpl();
	
	String s = null;
	
	try {
		s = employeeDao.EmployeeLogin(userName, pass);
	} catch (EngineerExecption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(s.equals("Employee Login Successfully!")) 
	{ 
		flag = true;
	}
	
	return flag;
}





public  void EmployeeUpdatePassword() {
	
	
	
	System.out.println("Enter the Employee Id ");
	
	int id = sc.nextInt();
	
	System.out.println("Enter UserName(Email)");
	String email = sc.next();
	
	System.out.println("Enter Current Password ");
	String currPass = sc.next();
	
	System.out.println("Enter New Password");
	String newPass = sc.next();
	
	EmployeeDao dao = new EmployeeDaoImpl();
	
	String   s = "Please Try Again Letter";
	
	s = dao.employeeUpdatePass(id, email, currPass, newPass);
	
	System.out.println(s);
		
	}


//Complain ----------------------------------------------------------------------

public void CreateComplain() {
	
	
	System.out.println("Enter complain Type (Software/HardWare");
	String Ctype = sc.next();
	System.out.println("Enter complain Statuc");
	String Cstatus = sc.next();
	
	
	System.out.println("Enter Employee ID");
	int EmployeeId  = sc.nextInt();
	
	ComplainBean complainBean = new ComplainBean(0,Cstatus, Ctype,  EmployeeId);
	
	ComplainDao complainDao = new ComplainDaoImpl();
	
	int id = complainDao.CreateNewComplain(complainBean);
	
	if(id>0) {
		System.out.println("Your Complain ID : "+ id);
	}
	
}



public void AssignedEngineer() {
	
	
	System.out.println("Enter Complain ID ");
	
	int cid = sc.nextInt();
	
	EngineerDao  engineerDao = new EngineerDaoImp();
	
	int EngineerID = engineerDao.getAssignedEngg(cid);
	
	String EngineerName = engineerDao.getEnggDetails(EngineerID);
	
	System.out.println("Your assingen Engineer Name is :" + EngineerName);
	
}


public void CheckStatusOfProblem() {
	
	System.out.println("Enter Complain ID");
	
	int cid = sc.nextInt();
	
	ComplainDao complainDao = new ComplainDaoImpl();
	
	String s = null;
	
	s = complainDao.checkComplainStatus(cid);
	
	System.out.println(s);
}




public void AllComplianHistoryList() {
	
	System.out.println("Enter Employee Id");
	
	int eid = sc.nextInt();
	
	ComplainDao complainDao = new ComplainDaoImpl();
	
	ArrayList<ComplainBean> list = complainDao.getComplainPerEmployee(eid);
	
	for(ComplainBean i : list) {
		
		System.out.println("Complain ID :" + i.getComplainId());
		
		System.out.println("Complain Status : " + i.getComplainStatus());
		
		System.out.println("Complain Type : " + i.getComplainType());
		
		System.out.println("Employee ID : " + i.getEmployeeId());
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
}

}




public class HomePage {
	
	
	

	public static void main(String[] args) {

		
		
		System.out.println("Walcome to The Online Hardware and software support system");
		
		
		Usecases usecases = new Usecases();
		
		
		System.out.println("Enter 1 for HOD Login");
		System.out.println("Enter 2 for Engineer Login");
		System.out.println("Enter 3 for Employee signup");
		System.out.println("Enter 4 for Employee Login");
		
		int x = Usecases.sc.nextInt();
		
		
		
		switch (x) {
		
		
//		HOD ----------------------------------------------------------------------------------
		case 1:
			
			
			if(usecases.HodLogin()) {
			
			System.out.println("=========================================");
			
			
			System.out.println("Enter 1 For Add  the Engineer");
			
			System.out.println("Enter 2 for All ENgineer List");
			
			System.out.println("Enter 3 for All Complain List");
			
			System.out.println("Enter 4 for All Complain List");
			
			System.out.println("Enter 5 for Delete Engineer");
			
			
			int y = Usecases.sc.nextInt();
			
			
			switch(y) {
			
			case 1: 
				usecases.AddEngineerByHOD();
				break;
			
			case 2:
				
				usecases.AllEngineersList();
				break;
				
			case 3: 
				usecases.AllComplainList();
				break;
				
				
					
				case 4: 
				usecases.assignComplainToEngineer();
				break;
				
				case 5: 
				usecases.RemoveEngineerByHOD();
				break;
				
				
				
			}
			
			}
			
			break;

			
//		Engineer ------------------------------------------------------	
			
		case 2: 
				if(usecases.EngineerLogin()) {
					
					System.out.println("---------------------------------");
					
					
					System.out.println("Press 1 to Update the Problem Status");
					System.out.println("Press 2 to Get all Assigend Problem List");
					System.out.println("press 3 for Update the Password");
					
					System.out.println("Press 4 for Mobile Number Updatation ");
					
					int y = Usecases.sc.nextInt();
					
					
					switch(y) {
					
					case 1:
						usecases.UpdateStatusByEngineer();
						break;
						
					case 2 :
						
						usecases.getComplainAssigenToEngineer();
						break;
						
					case 3: 
						usecases.EngineerUpdatePassword();
						break;
					
					case 4:
						
						usecases.ENgineerUpdateMobileNumber();
						break;
						
					
						
						
						
					}		
							
				}
			   
			break;
			
//	    Employee -----------------------------------------------------------------------------
			
			
		case 3:
			
			usecases.EmployeeRegistration() ;
			break;
			
//			Complain -------------------------------------------------------------------------
		case 4: 
			
			if(usecases.EmployeeLogin()) {
				
				System.out.println("================================================");
				
				
				System.out.println("Enter 1 For Creating Complain");
				
				System.out.println("Enter 2 for Know About Assigen Engineer");
				
				System.out.println("Enter 5 for Check status of Complain");
				System.out.println("Enter 3 for List of all complain history");
				
				System.out.println("Enter 4 for Update Password");
				
				
				int y = Usecases.sc.nextInt();
				
				
				switch(y) {
				
				case 1: 
					usecases.CreateComplain();
					break;
				
				case 2:
					usecases.AssignedEngineer();
					
					break;
					
				case 3:
					usecases.AllComplianHistoryList();
					break;
					
				case 4: 
					usecases.EmployeeUpdatePassword();
					break;
				case 5 :
					usecases.CheckStatusOfProblem();
					break;
					
					
					
				}
				
				
			}
			
			
			break;
			
			
			
			
		default:
			System.out.println("CHIll bro");
			break;
		}
		
	}
}
