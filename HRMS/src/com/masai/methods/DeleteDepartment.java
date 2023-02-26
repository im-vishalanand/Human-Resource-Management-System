package com.masai.methods;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.ui.AdminLink;

public class DeleteDepartment {

	public static void delete() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Department Name :");
		String deptname=sc.next();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		String res="";
		
		try {
			res=dao.deleteDepartment(deptname);
			System.out.println(res);
			try {
				AdminLink.linkingAdmin();
			} catch (SQLException | EmployeeException e) {
				e.printStackTrace();
			}
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
	}
}
