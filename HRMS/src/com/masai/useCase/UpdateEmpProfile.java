package com.masai.useCase;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class UpdateEmpProfile {
	
	public static void main(int eid) throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Username  : ");
		String empUsername=sc.next();
		System.out.println("Enter New Password  : ");
		String empPassword=sc.next();
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		
		String result = emp.updateEmployee(empUsername,empPassword, eid);
		System.out.println(result);
		
		sc.close();
		
	}
}
