package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dto.Employee;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.methods.LoginEmployee;

public class Main {
	
	static int empId;
	static String empName;
	static String empUsername;
	static String empPassword;
	static int empDid;
	
	
	static boolean	flag=true;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		try {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("     WELCOME ");
			Thread.sleep(300);
			
			System.out.print("TO ");
			Thread.sleep(300);
			
			System.out.print("HUMAN ");
			Thread.sleep(300);
			
			System.out.print("RESOURCE ");
			Thread.sleep(300);
			
			System.out.print("MANAGEMENT ");
			Thread.sleep(300);
			
			System.out.print("SYSTEM ");
			Thread.sleep(300);
			
			System.out.println();
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println();
			Thread.sleep(300);
			System.out.println("Please Choose Option: ");
			Thread.sleep(300);
			
			System.out.println();
			System.out.println("Press 1 ---> Login As Admin");
			Thread.sleep(300);
			System.out.println("Press 2 ---> Login As Employee");
			Thread.sleep(300);
			System.out.println("Press 3 ---> Exit");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.print("Select an Option: ");
		int choice =sc.nextInt();
		System.out.println();
		
		if(choice==1) {
			System.out.print("Enter Admin Username : ");
			String username=sc.next();
			
			System.out.print("Enter Admin Password : ");
			String password = sc.next();
			System.out.println();
			
			if(username.equals("admin") && password.equals("admin")) {
				try {
					AdminLink.linkingAdmin();
				} catch (SQLException | DepartmentException | EmployeeException e) {
					
					System.out.println("Something went wrong");
				}
			}
			else  {
				System.out.println("Wrong Admin Credentials. Please Try Again");
				System.out.println();
				main(null);
			}
		}
		else if(choice==2) {
			Employee emp=LoginEmployee.loginEmployee();
			empId=emp.getEmpId();
			empName=emp.getEmpName();
			empUsername=emp.getEmpUsername();
			empPassword=emp.getEmpPassword();
			empDid=emp.getEmpDid();
			EmployeeLink.linkingEmployeeMethod();
		}
		else if(choice==3) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("   Application  Closed");
			System.out.println("       Thank  You");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		
		else {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("Wrong input. Please Choose a Correct Option");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			main(null);
		}
	}
}
