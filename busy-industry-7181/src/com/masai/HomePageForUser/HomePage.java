package com.masai.HomePageForUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
import com.masai.exceptions.WrongOptionSelect;


public class HomePage {
	
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
	

	public static void main(String[] args) throws IOException {

		
		
		System.out.println("\n Walcome to The Online \n Hardware and software support system \n");
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		
		try {
			
		
		
		Usecases usecases = new Usecases();
		
		
		System.out.println("Enter 1 for HOD Login \n");
		System.out.println("Enter 2 for Engineer Login \n");
		System.out.println("Enter 3 for Employee signup \n");
		System.out.println("Enter 4 for Employee Login \n");
		int x = Integer.parseInt(sc.readLine().trim());
		
		
		
			
		switch (x) {
		
		
//		HOD ----------------------------------------------------------------------------------
		case 1:
			while(true) {
			
			
			if(usecases.HodLogin()) {
			
			System.out.println("=========================================");
			
			
			System.out.println("Enter 1 For Add  the Engineer");
			
			System.out.println("Enter 2 for All ENgineer List");
			
			System.out.println("Enter 3 for All Complain List");
			
			System.out.println("Enter 4 for  assingn Complain To engineer");
			
			System.out.println("Enter 5 for Delete Engineer");
			
			
			int y = Integer.parseInt(sc.readLine().trim());
			
			
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
				
				
				default:
					System.out.println("You enter Wrong option!");
					break;
				
			}
			
			}
		
			
			break;
	}
			
//		Engineer ------------------------------------------------------	
			
		case 2: 
				if(usecases.EngineerLogin()) {
					
					System.out.println("---------------------------------");
					
					
					System.out.println("Press 1 to Update the Problem Status");
					System.out.println("Press 2 to Get all Assigend Problem List");
					System.out.println("press 3 for Update the Password");
					
					System.out.println("Press 4 for Mobile Number Updatation ");
					
					int y = Integer.parseInt(sc.readLine().trim());
//							Usecases.sc.nextInt();
					
					
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
						
					
						
					default:
						System.out.println("You enter Wrong option!");
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
				
				
				int y = Integer.parseInt(sc.readLine().trim());
//						Usecases.sc.nextInt();
				
				
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
					
					
				default:
					System.out.println("You enter Wrong option!");
					break;
					
				}
				
				
			}
			
			
			break;
			
			
			
			
		default:
			System.out.println("You enter Wrong option!");
			break;
		}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println( "Please Enter wright Key " );
		}
	}
}
