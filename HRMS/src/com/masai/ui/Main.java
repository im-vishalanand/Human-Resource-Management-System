package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;
import com.masai.useCase.LoginEmployee;

public class Main {
	
	static boolean	flag=true;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		try {
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
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println();
			Thread.sleep(300);
			System.out.println("Please Choose Option: ");
			Thread.sleep(300);
			
			System.out.println();
			System.out.println("Press 1 --->  for Login As Admin");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 2 ---> for login As Employee");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 3 ---> for Exit");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.print("Option: ");
		int choice =sc.nextInt();
		
		switch(choice) {
		case 1:{
			System.out.println();
			System.out.println("Enter Admin Username : ");
			String username=sc.next();
			
			System.out.println("Enter Admin Password : ");
			String password = sc.next();
			
			if(username.equals("admin") && password.equals("admin")) {
				try {
					AdminLink.linkingAdmin();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else  {
				System.out.println("Wrong Username or Password");
			}
			break;
		}
		case 2:{
			try {
				EmployeeImpl emp=LoginEmployee.loginEmployee();
				EmployeeLink.linkingEmployeeMethod(emp);
			} catch (EmployeeException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		}
		case 3:{
			System.out.println();
			System.out.println("   Application  Closed");
			System.out.println("       Thank  You");
			System.out.println("-------------------------");
			break;
		}
		
		default:
			try {
				System.out.println("Invalid  key");
				Thread.sleep(200);
				System.out.println("Please choose a valid key");
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sc.close();
	}
}
