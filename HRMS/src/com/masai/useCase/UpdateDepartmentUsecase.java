package com.masai.useCase;

import java.util.Scanner;
import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.DepartmentException;


public class UpdateDepartmentUsecase {

		public static void main(String[] args) throws DepartmentException {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter Department deptId : ");
				int deptid=sc.nextInt();
				
				System.out.println("Enter Department Name : ");
				String deptname=sc.next();
				
				DepartmentDao dao=new DepartmentDaoImpl();
				
				Department department = new DepartmentImpl();
				
				department.setDeptName(deptname);
				department.setDeptNo(deptid);
				
				String result = dao.updateDepartment(department);
				
				System.out.println(result);
				
				sc.close();
			}
	
}
