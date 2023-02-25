package com.masai.useCase;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class ChangePassword {
	
	public static void main(int id) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter New Password : ");
		String pass= sc.next();
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		String res = emp.changePassword(id, pass);
		
		System.out.println(res);
		
		sc.close();
		
	}

}
