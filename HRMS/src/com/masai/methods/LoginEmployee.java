package com.masai.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.DBUtils;
import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;

public class LoginEmployee {
	
	
	public static Employee loginEmployee(){
   		
		Employee emp=null;
   		Scanner sc=new Scanner(System.in);
   		
   		System.out.print("Enter Your Username: ");
   		String email=sc.next();
   		
   		System.out.print("Enter Your Password: ");
   		String password=sc.next();
   		System.out.println();
   		
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
   				emp.setEmpDid(rs.getInt("empDid"));
   				
   				if(!emp.getEmpPassword().equals(password)) {
   					
   					throw new EmployeeException("Wrong Password");
   				}
   			}
   			else {
   				throw new EmployeeException("Email ID not exist");
   			}
   			
   		} catch (SQLException | EmployeeException e) {
   			System.out.println("Wrong Username or Password");
   			loginEmployee();
   		}
   		return emp;		
	}
}
