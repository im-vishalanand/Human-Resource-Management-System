package com.masai.methods;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;
import com.masai.ui.AdminLink;

public class AcceptLeave {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id  : ");
		int empid=sc.nextInt();
		
		LeavesDao l = new LeavesDaoImpl();
		String result="";
		try {
			result = l.approveLeave(empid);
			System.out.println(result);
			AdminLink.linkingAdmin();
		} catch (LeaveException | SQLException | DepartmentException | EmployeeException e) {
			e.printStackTrace();
		}
	}

}
