package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;

public class DepartmentDaoImpl implements DepartmentDao{
	
	boolean isEmptyResultSet(ResultSet result) throws SQLException {
		return (!result.isBeforeFirst() && result.getRow()==0?true:false);
	}
	
	List<Department> getDepartment(ResultSet result) throws SQLException{
		List<Department> dept=new ArrayList<>();
		
		while(result.next()) {
			Department em=new DepartmentImpl();
			
			em.setDeptName(result.getString("deptname"));
			em.setDeptNo(result.getInt("deptno"));
			
			dept.add(em);
		}
		return dept;
	}

	@Override
	public String registerDepartment(String name) throws DepartmentException {
		Connection conn=null;
		String message="";
		try {
			conn= DBUtils.createConnection();
			
			String addQuery="insert into department (deptname) values(?)";
			
			PreparedStatement ps = conn.prepareStatement(addQuery);
			
			ps.setString(1, name);
			
			int result=ps.executeUpdate();
			
			if(result>0) {
				message = "New Department Added !";				
			}
			else {
				throw new DepartmentException("Cannot add, Something went wrong");
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
	public List<Department> allDepartment() throws DepartmentException, SQLException {
		Connection conn=null;
		
		List<Department> dept=new ArrayList<>();
		
		try {
			conn=DBUtils.createConnection();
			
			String query="select * from department";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				String deptName= rs.getString("deptName");
				int deptNo = rs.getInt("deptNo");
				
				Department department= new DepartmentImpl(deptName, deptNo) ;
				
				dept.add(department);
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
		
		return dept;
	}

	@Override
	public String updateDepartment(Department department) throws DepartmentException {
		Connection conn=null;
		String message="";
		try {
			conn= DBUtils.createConnection();
			
			String updateQuery="update department set deptname=? where deptno=?";
			
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			
			ps.setString(1, department.getDeptName());
			ps.setInt(2, department.getDeptNo());			
			
				int result=ps.executeUpdate();
			
			if(result>0) {
				message="Department updated successfully";
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

}
