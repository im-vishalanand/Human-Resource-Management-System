package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;

public interface EmployeeDao {

	public Employee loginEmployee(String Username , String password) throws EmployeeException,SQLException;
	public String registerEmployee(Employee employee) throws EmployeeException;
	public List<Employee> getAllEmployee()throws EmployeeException;
	public Employee getEmployeeById(int empid) throws EmployeeException, SQLException;
	public String changeDepartment(int employeeID, int newDepartmentID) throws EmployeeException;
	public String updateEmployee( String username,String password, int empid) throws EmployeeException;
	public String changePassword(int empid, String password) throws EmployeeException;
}
