package com.masai.methods;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;
import com.masai.ui.AdminLink;

public class RejectLeave {
	
	public static void main(int id) {
		Scanner sc=new Scanner(System.in);
//		int id=sc.nextInt();
		LeavesDao l=new LeavesDaoImpl();
		String res="";
		try {
			res = l.rejectLeave(id);
			System.out.println(res);
			AdminLink.linkingAdmin();
			
		} catch (LeaveException | SQLException | DepartmentException | EmployeeException e) {
			e.printStackTrace();
			try {
				AdminLink.linkingAdmin();
			} catch (SQLException | DepartmentException | EmployeeException e1) {
				e1.printStackTrace();
			}
		}		
	}

}
