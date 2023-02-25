package com.masai.useCase;

import java.util.List;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;

public class ViewAllEmployee {

	public static void main(String[] args) {
		
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
		} catch (EmployeeException e) {
				e.printStackTrace();
			
		}
	}
	
}
