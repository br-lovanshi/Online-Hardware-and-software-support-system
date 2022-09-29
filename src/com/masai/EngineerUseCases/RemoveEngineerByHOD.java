package com.masai.EngineerUseCases;
//package com.masai.HODusecases;
//
//import java.util.Scanner;
//
//import com.masai.dao.EngineerDao;
//import com.masai.dao.EngineerDaoImp;
//import com.masai.exceptions.EngineerExecption;
//
//public class RemoveEngineerByHOD {
//
//	public boolean RemoveEngineerByHOD() {
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Engineer ID ");
//		
//		int id = sc.nextInt();
//		
//		EngineerDao engineerDao = new EngineerDaoImp();
//		String s = null;
//		try {
//			s = engineerDao.removeEngineerByHODViaID(id);
//		} catch (EngineerExecption e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(s);
//	}
//}
