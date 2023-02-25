package com.masai.useCase;

import java.util.Scanner;
import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.DepartmentException;

public class AddDepartmentUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Department Name :");
		String deptname=sc.next();
		
		System.out.println("Enter Department no : ");
		int deptNo=sc.nextInt();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		Department dept = new DepartmentImpl();
		
		
		String result="";
		try {
			result = dao.registerDepartment(dept);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		sc.close();
		
	}
	
	public static void register() throws DepartmentException {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Department Name :");
		String deptname=sc.next();
		
		System.out.println("Enter Department no : ");
		int deptNo=sc.nextInt();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		Department department = new DepartmentImpl();
		
		department.setDeptName(deptname);
		department.setDeptNo(deptNo);
		
		String result = dao.registerDepartment(department);
		
		System.out.println(result);
		
		sc.close();
	}
	
	
}
