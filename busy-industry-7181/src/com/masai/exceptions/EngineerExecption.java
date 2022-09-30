package com.masai.exceptions;

public class EngineerExecption extends Exception {

	public EngineerExecption() {
		// TODO Auto-generated constructor stub
	}
	
	public EngineerExecption(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
