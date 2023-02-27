package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.exception.LeaveException;
import com.masai.ui.EmployeeLink;

public class ApplyLeave {

	public static void main(int empId){
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Employee Id  : ");
//		int empId= sc.nextInt();
		
		LeavesDao l = new LeavesDaoImpl();
		String result="";
		try {
			result = l.requestLeave(empId);
			System.out.println(result);
			EmployeeLink.linkingEmployeeMethod();
		} catch (LeaveException e) {
			System.out.println("Cannot apply for leave");
			EmployeeLink.linkingEmployeeMethod();			
		}
	}
}
