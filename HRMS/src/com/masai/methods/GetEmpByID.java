package com.masai.methods;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;
import com.masai.ui.EmployeeLink;

public class GetEmpByID {
	
	public static void main(int empid) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Employee Id: ");
//		int empid=sc.nextInt();
		EmployeeDao empl= new EmployeeDaoImpl();
		
		try {
			System.out.println(empl.getEmployeeById(empid));
			EmployeeLink.linkingEmployeeMethod();
		} catch (EmployeeException | SQLException e) {
			System.out.println("Employee not found");
			EmployeeLink.linkingEmployeeMethod();
		}
	}
}
