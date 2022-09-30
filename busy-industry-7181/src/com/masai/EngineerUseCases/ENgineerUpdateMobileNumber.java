package com.masai.EngineerUseCases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImp;
import com.masai.exceptions.EngineerExecption;

public class ENgineerUpdateMobileNumber {
	
	
public  void ENgineerUpdateMobileNumber(String[] args) {
		
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
}
