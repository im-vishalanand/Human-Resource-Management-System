package com.masai.useCase;

import java.sql.SQLException;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;

public class GetEmpByID {
	
	public static void main(int empid) {
		
		
		EmployeeDao empl= new EmployeeDaoImpl();
		
		try {
			Employee emp = empl.getEmployeeById(empid);
			System.out.println(emp);
		} catch (SQLException | EmployeeException e) {
			e.printStackTrace();
		}
		
	}
}
