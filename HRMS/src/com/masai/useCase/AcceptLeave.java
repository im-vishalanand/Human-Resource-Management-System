package com.masai.useCase;

import java.util.Scanner;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exception.LeaveException;

public class AcceptLeave {
	
	public static void main(String[] args) throws LeaveException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id  : ");
		int empid=sc.nextInt();
		
		DepartmentDao dept = new DepartmentDaoImpl();
		String result = dept.acceptLeaves(empid);
		System.out.println(result);
		
		sc.close();
	}

}
