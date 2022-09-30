package com.masai.EngineerUseCases;

import java.util.Scanner;

import com.masai.bean.EngineerBean;
import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImp;

//public class AddEngineerByHOD {
//
//	public static void AddEngineerByHOD() {
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Engineer Name");
//		String name = sc.next();
//		System.out.println("Enter Engineer Email");
//		String email = sc.next();
//		System.out.println("Enter Engineer Mobile");
//		int mobile = sc.nextInt();
//		System.out.println("Enter Engineer PassWord");
//		String pass  = sc.next();
//		
//		EngineerBean bean = new EngineerBean(0,name,email,mobile,pass);
//		
//		EngineerDao engineerDao = new EngineerDaoImp();
//		
//		int engId = engineerDao.addEngineer(bean);
//		
//		if(engId>0)
//		System.out.println("Your Engineer ID is : " + engId);
//		
//	}
//}
