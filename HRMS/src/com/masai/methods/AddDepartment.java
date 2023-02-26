package com.masai.methods;

import java.util.Scanner;
import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.DepartmentException;

public class AddDepartment {
	
	public static void register() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Department Name :");
		String deptname=sc.next();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		String res="";
		
		try {
			res=dao.registerDepartment(deptname);
			System.out.println(res);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	
}
