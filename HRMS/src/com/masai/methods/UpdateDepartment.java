package com.masai.methods;

import java.util.Scanner;
import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.DepartmentException;


public class UpdateDepartment {

		public static void main(String[] args) {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter Department No : ");
				int deptid=sc.nextInt();
				
				System.out.println("Enter Department Name : ");
				String deptname=sc.next();
				
				DepartmentDao dept=new DepartmentDaoImpl();
				
				Department department = new DepartmentImpl();
				
				department.setDeptName(deptname);
				department.setDeptNo(deptid);
				
				String result="";
				try {
					result = dept.updateDepartment(department);
				} catch (DepartmentException e) {
					e.printStackTrace();
				}
				
				System.out.println(result);
				
				sc.close();
			}
	
}