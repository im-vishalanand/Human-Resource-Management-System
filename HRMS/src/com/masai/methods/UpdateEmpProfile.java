package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class UpdateEmpProfile {
	
	public static void main(int eid){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Username  : ");
		String empUsername=sc.next();
		System.out.println("Enter New Password  : ");
		String empPassword=sc.next();
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		
		String result="";
		try {
			result = emp.updateEmployee(empUsername,empPassword, eid);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		sc.close();
		
	}
}
