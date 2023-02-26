package com.masai.methods;

import java.util.Scanner;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;

public class AddEmployee {
	
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Name :");
			String empname=sc.next();
			
			System.out.println("Enter Employee Username : ");
			String empusername=sc.next();
			
			System.out.println("Enter Employee Password : ");
			String emppassword = sc.next();
			
			System.out.println("Enter Employee Department Id : ");
			int empdid=sc.nextInt();
			
			EmployeeDao empl =new EmployeeDaoImpl();
			Employee emp = new EmployeeImpl();
			
			emp.setEmpName(empname);
			emp.setEmpUsername(empusername);
			emp.setEmpPassword(emppassword);
			emp.setEmpDid(empdid);
			
			String result="";
			try {
				result = empl.registerEmployee(emp);
			} catch (EmployeeException e) {
				e.printStackTrace();
			}
			
			System.out.println(result);
			
			sc.close();
		}

}
