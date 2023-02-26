package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.ui.EmployeeLink;

public class ChangePassword {
	
	public static void main(int id) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Employee Id : ");
		int empid= sc.nextInt();
		System.out.println("Enter New Password : ");
		String pass= sc.next();
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		String res="";
		try {
			res = emp.changePassword(empid, pass);
			System.out.println(res);
			EmployeeLink.linkingEmployeeMethod();
		} catch (EmployeeException e) {
			System.out.println("Cannot Change Password");
			EmployeeLink.linkingEmployeeMethod();
		}
	}
}
