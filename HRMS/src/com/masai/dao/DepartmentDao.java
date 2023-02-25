package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import com.masai.dto.Department;
import com.masai.exception.DepartmentException;
import com.masai.exception.LeaveException;

public interface DepartmentDao {

	public String registerDepartment(Department department) throws DepartmentException;
	public List<Department> allDepartment()throws DepartmentException,SQLException;
	public String updateDepartment(Department department) throws DepartmentException;
	public String acceptLeaves(int empId) throws LeaveException;
	public String rejectLeaves(int empId);
}
