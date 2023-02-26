package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.exception.LeaveException;

public class AcceptLeave {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id  : ");
		int empid=sc.nextInt();
		
		LeavesDao l = new LeavesDaoImpl();
		String result="";
		try {
			result = l.approveLeave(empid);
		} catch (LeaveException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		sc.close();
	}

}
