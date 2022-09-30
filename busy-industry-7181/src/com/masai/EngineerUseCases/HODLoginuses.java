package com.masai.EngineerUseCases;

import java.util.Scanner;

import com.masai.bean.HodBean;
import com.masai.dao.HodDao;
import com.masai.dao.HodDaoImpl;
import com.masai.exceptions.EngineerExecption;
//
//public class HODLoginuses {
//
//	public static void main(String[] args) throws EngineerExecption {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter HOD Email(UserName)");
//		String Email  = sc.next();
//		System.out.println("Enter HOD Password");
//		String Pass = sc.next();
//		
//		HodBean hodBean = new HodBean( Email, Pass);
//		
//		HodDao hodDao = new HodDaoImpl();
//		
//		String s = hodDao.HodLogin(hodBean);
//		System.out.println(s);
//		
//	}
//}
