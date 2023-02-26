package com.masai.methods;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;

public class GetEmpByID {
	
	public static void main(int empid) {
		Scanner sc=new Scanner(System.in);
		int empid1=sc.nextInt();
		EmployeeDao empl= new EmployeeDaoImpl();
		
		try {
			Employee emp = empl.getEmployeeById(empid1);
			System.out.println(emp);
		} catch (SQLException | EmployeeException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}
}
