package com.masai.useCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.DBUtils;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;

public class LoginEmployee {
	
//	public static void main(String[] args) {
//		
//	}
	
	public static EmployeeImpl  loginEmployee() throws EmployeeException, SQLException {
		EmployeeImpl emp=null;
   		
   		Scanner sc=new Scanner(System.in);
   		
   		System.out.println("Enter Your User Name");
   		String email=sc.next();
   		
   		System.out.println("Enter Your Password");
   		String password=sc.next();
   		
   		Connection conn=null;
   		
   		
   		try {
   			conn=DBUtils.createConnection();
   			
   			String query="select * from employee where empusername=?";
   			
   			PreparedStatement ps=conn.prepareStatement(query);
   			
   			ps.setString(1, email);
   			
   			ResultSet rs=ps.executeQuery();
   			
   			if(rs.next()) {
   				emp=new EmployeeImpl();
   				emp.setEmpId(rs.getInt("empid"));
   				emp.setEmpName(rs.getString("empname"));
   				emp.setEmpUsername(rs.getString("empusername"));
   				emp.setEmpPassword(rs.getString("emppassword"));
   				emp.setEmpId(rs.getInt("empdid"));
   				
   				if(!emp.getEmpPassword().equals(password)) {
   					
   					throw new EmployeeException("Wrong Password");
   					
   				}
   				
   			}
   			else {
   				throw new EmployeeException("Email ID not exist");
   			}
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
   		
   		sc.close();
   		return emp;		
   		
	}
}
