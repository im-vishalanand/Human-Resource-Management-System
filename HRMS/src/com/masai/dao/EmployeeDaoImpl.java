package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;

public class EmployeeDaoImpl implements EmployeeDao{
	
	boolean isEmptyResultSet(ResultSet result) throws SQLException {
		return (!result.isBeforeFirst() && result.getRow()==0?true:false);
	}
	
	List<Employee> getEmployee(ResultSet result) throws SQLException{
		List<Employee> emp=new ArrayList<>();
		
		while(result.next()) {
			Employee em=new EmployeeImpl();
			
			em.setEmpId(result.getInt("empid"));
			em.setEmpName(result.getString("empname"));
			em.setEmpUsername(result.getString("empusername"));
			em.setEmpPassword(result.getString("emppassword"));
			em.setEmpDid(result.getInt("empDid"));
			
			emp.add(em);
		}
		return emp;
	}

	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException{
		
		Connection conn= null;
		
		Employee employee=null;
		
		try{
			conn= DBUtils.createConnection();
			
			String loginQuery="select * from Employee where empusername=? AND emppassword=?";
			
			PreparedStatement ps= conn.prepareStatement(loginQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				int eid= rs.getInt("empid");
				String empName= rs.getString("empname");
				String empUsername =rs.getString("empusername");
				String emppassword=rs.getString("emppassword");
				int edid = rs.getInt("Edid");
				
				employee= new EmployeeImpl(eid, empName, empUsername, emppassword, edid);
			}
			else 
				throw new EmployeeException("Invalid Username or Password.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public String registerEmployee(Employee employee) throws EmployeeException {
		Connection conn=null;
		String message="";
		try {
			conn= DBUtils.createConnection();
			
			String addQuery="insert into employee (empname, empusername, emppassword, empdid) values(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(addQuery);
			
			ps.setString(1, employee.getEmpName());
			ps.setString(2, employee.getEmpUsername());
			ps.setString(3, employee.getEmpPassword());
			ps.setInt(4, employee.getEmpDid());
			
			int result=ps.executeUpdate();
			
			if(result>0) {
				message = "New Employee Added !";				
			}
			else {
				throw new EmployeeException("Cannot add, Something went wrong");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return message;
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		Connection conn=null;
		
		List<Employee> emp=new ArrayList<>();
		
		try {
			conn=DBUtils.createConnection();
			
			String query="select * from employee";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Employee e= new EmployeeImpl();
				e.setEmpId(rs.getInt("empid"));
	        	e.setEmpName(rs.getString("empname"));
	        	e.setEmpUsername(rs.getString("empusername"));
				e.setEmpPassword(rs.getString("emplpassword"));
				e.setEmpDid(rs.getInt("empdid"));
				
				emp.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return emp;
		
	}

	@Override
	public Employee getEmployeeById(int empid) throws EmployeeException, SQLException {
		Connection conn=null;
		
		Employee employee=null;
		try {
			conn=DBUtils.createConnection();
			
			String getQuery="select * from employee where empid=?";
			
			PreparedStatement ps= conn.prepareStatement(getQuery);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int eid= rs.getInt("empid");
				String empname= rs.getString("empName");
				String empusername=rs.getString("empusername");
				String pass=rs.getString("emppassword");
				int edid = rs.getInt("empdid");
				
				employee= new EmployeeImpl(eid, empname, empusername, pass, edid);
			}
			else {
				throw new EmployeeException("Employee Does not exist with Eid "+empid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return employee;	
	}

	@Override
	public String updateEmployee(String username, String password, int empid) throws EmployeeException {
		Connection conn=null;
		String message="";
		try {
			conn= DBUtils.createConnection();
			
			String updateQuery="update employee set empusername=? , emppassword=? where empid=?";
			
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, empid);
			
			
			if(ps.executeUpdate()>0) {
				message="Employee updated successfully";
			}
			else {
				throw new EmployeeException("Cannot update Employee, Try Again!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return message;
	}

	@Override
	public String changePassword(int empid, String password) {
		Connection conn=null;
		String message="";
		try {
			conn= DBUtils.createConnection();
			
			String updateQuery="update employee set emppassword=? where eid=?";
			
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			
			ps.setString(1, password);
			ps.setInt(2, empid);
			
			
			if(ps.executeUpdate()>0) {
				message="Password changed successfully";
			}
		} catch (SQLException e) {
			message="Cannot change Password, Try Again!";
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return message;
	}

}
