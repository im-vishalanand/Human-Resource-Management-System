package com.masai.methods;

import java.sql.SQLException;
import java.util.List;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.dto.Department;
import com.masai.exception.DepartmentException;

public class ViewAllDepartment {
		
		public static void main(String[] args) throws SQLException {
						
			DepartmentDao dept = new DepartmentDaoImpl();
			try {
				
				List<Department> dep=dept.allDepartment();
				
				dep.forEach(e->{
					System.out.println("Department name is : "+ e.getDeptName());
					System.out.println("Department ID is : "+e.getDeptNo());
											
					System.out.println("=====================================");
					});
			} catch (DepartmentException e) {
				e.printStackTrace();
			}
		}	
}

