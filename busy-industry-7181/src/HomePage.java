

import java.util.ArrayList;
import java.util.Scanner;

import com.masai.bean.EngineerBean;
import com.masai.bean.HodBean;
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
		String email = sc.next();
		
		System.out.println("Enter Current Password ");
		String currPass = sc.next();
		
		System.out.println("Enter New Password");
		String newPass = sc.next();
		
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
	
	
	
	
	
	
}



public class HomePage {
	
	
	

	public static void main(String[] args) {

		
		
		System.out.println("Walcome to The Online Hardware and software support system");
		
		
		Usecases usecases = new Usecases();
		
		
		System.out.println("Enter 1 for HOD Login");
		System.out.println("Enter 2 for Engineer Login");
		int x = Usecases.sc.nextInt();
		
		
		
		switch (x) {
		
		
//		HOD ----------------------------------------------------------------------------------
		case 1:
			
			
			if(usecases.HodLogin()) {
			
				
			System.out.println("Enter 1 For Add  the Engineer");
			
			System.out.println("Enter 2 for All ENgineer List");
			
			System.out.println("Enter 3 for Delete Engineer");
			
			
			int y = Usecases.sc.nextInt();
			
			
			switch(y) {
			
			case 1: 
				usecases.AddEngineerByHOD();
				break;
			
			case 2:
				
				usecases.AllEngineersList();
				break;
				
			case 3: 
				usecases.RemoveEngineerByHOD();
				break;
				
				
				
				
			}
			
			}
			
			break;

			
//		Engineer ------------------------------------------------------	
		case 2: 
				if(usecases.EngineerLogin()) {
					
					System.out.println("---------------------------------");
					
					System.out.println("press 1 for Update the Password");
					
					System.out.println("Press 2 for Mobile Number Updatation ");
					
					int y = Usecases.sc.nextInt();
					
					
					switch(y) {
					
					case 1: 
						usecases.EngineerUpdatePassword();
						break;
					
					case 2:
						
						usecases.ENgineerUpdateMobileNumber();
						break;
						
					case 3: 
						usecases.RemoveEngineerByHOD();
						break;
						
						
						
						
					}		
							
				}
			   
			break;
			
//	    Employee -----------------------------------------------------------------------------
		case 3:
			
			
			
		default:
			System.out.println("CHIll bro");
			break;
		}
		
	}
}
