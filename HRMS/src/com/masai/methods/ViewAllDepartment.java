package com.masai.methods;

import java.sql.SQLException;
import java.util.List;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.ui.AdminLink;

public class ViewAllDepartment {
		
		public static void main(String[] args) throws SQLException, DepartmentException, EmployeeException {
						
			DepartmentDao dept = new DepartmentDaoImpl();
			try {
				
				List<Department> dep=dept.allDepartment();
				
				dep.forEach(e->{
					System.out.println("Department name is : "+ e.getDeptName());
					System.out.println("Department ID is : "+e.getDeptNo());
											
					System.out.println("=====================================");
					});
				AdminLink.linkingAdmin();
			} catch (DepartmentException e) {
				System.out.println("No Department Found!");
				AdminLink.linkingAdmin();
			}
		}	
}

