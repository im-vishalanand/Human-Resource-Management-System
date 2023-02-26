package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;
import com.masai.ui.EmployeeLink;

public class UpdateEmpProfile {
	
	public static void main(int empId){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Username  : ");
		String empUsername=sc.next();
		System.out.println("Enter New Password  : ");
		String empPassword=sc.next();
		
		EmployeeDao empl=new EmployeeDaoImpl();
		
		String result="";
		try {
			result = empl.updateEmployee(empUsername,empPassword, empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		EmployeeLink.linkingEmployeeMethod();
		
	}
}
