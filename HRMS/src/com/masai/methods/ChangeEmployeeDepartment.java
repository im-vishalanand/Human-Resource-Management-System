package com.masai.methods;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.ui.AdminLink;


public class ChangeEmployeeDepartment {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int empid=sc.nextInt();
		System.out.println("Enter New Department ID: ");
		int newDptid=sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		
		try {
			String res = dao.changeDepartment(empid, newDptid);
			System.out.println(res);
			AdminLink.linkingAdmin();
		} catch (EmployeeException | SQLException | DepartmentException e) {
			System.out.println("Cannot change Department");
			try {
				AdminLink.linkingAdmin();
			} catch (SQLException | DepartmentException | EmployeeException e1) {
				e1.printStackTrace();
			}			
		}
	}
}
