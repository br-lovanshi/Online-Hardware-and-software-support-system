//package com.masai.EngineerUseCases;
//
//import java.util.ArrayList;
//
//import com.masai.bean.EngineerBean;
//import com.masai.dao.EngineerDao;
//import com.masai.dao.EngineerDaoImp;
//
//public class AllEngineersList {
//
//	
//	public static void main(String[] args) {
//		
//		EngineerDao engineerDao = new EngineerDaoImp();
//		
//
//	ArrayList<EngineerBean> bean	 = engineerDao.allEngineersList();
//	
//	for(EngineerBean i : bean) {
//		System.out.println("Engineer id " + i.getEnggId());
//		System.out.println("Engineer Name : " + i.getEnggName());
//		System.out.println("Engineer Email : " + i.getEnggMail());
//		System.out.println("Engineer Mobile : " +i.getEnggMobile());
//		System.out.println("Engineer password : " +i.getEnggPassword());
//		System.out.println("------------------------------------------------");
//	}
//	
//	}
//}
