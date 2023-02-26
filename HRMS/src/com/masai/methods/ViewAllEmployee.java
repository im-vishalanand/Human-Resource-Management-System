package com.masai.methods;

import java.sql.SQLException;
import java.util.List;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.ui.AdminLink;

public class ViewAllEmployee {

	public static void main(String[] args) throws SQLException, DepartmentException, EmployeeException {
		
		EmployeeDao empl=new EmployeeDaoImpl();
		List<Employee> emp;
		try {
			 emp = empl.getAllEmployee();
			 
			 emp.forEach(e->{
					System.out.println("Employee Id is : "+ e.getEmpId());
					System.out.println("Employe name is : "+e.getEmpName());
					System.out.println("Employee username is : "+e.getEmpUsername());
					System.out.println("Employee password is : "+e.getEmpPassword());
					System.out.println("Employee Department Id is "+e.getEmpDid());
					
					System.out.println("=====================================");
			 });
			 AdminLink.linkingAdmin();
		} catch (EmployeeException e) {
				System.out.println("No Employee found");
				AdminLink.linkingAdmin();
		}
	}
	
}
