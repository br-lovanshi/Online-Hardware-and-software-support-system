//package com.masai.EngineerUseCases;
//
//import java.util.Scanner;
//
//import com.masai.bean.EmployeeBean;
//import com.masai.dao.EmployeeDao;
//import com.masai.dao.EmployeeDaoImpl;
//
//public class EmployeeRegistration {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Employee Name");
//		String EmployeeName = sc.next().trim();
//	
//		System.out.println("Employee Email");
//		
//		String email = sc.next().trim();
//
//		System.out.println("Employee Mobile Number");
//		
//		int mobile = sc.nextInt();
//		
//		System.out.println("Employee City (optional)");
//		
//		String city = sc.next().trim();
//		
//		System.out.println("Employee Password");
//		String pass = sc.next().trim();
//		
//		EmployeeBean employeeBean = new EmployeeBean(0, EmployeeName, email, mobile, city, pass);
//			
//	
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		 int id = dao.employeeRegistration(employeeBean);
//		
//		if(id>0)
//		System.out.println("Employee Id :- " +id);
//		
//				
//	}
//}
