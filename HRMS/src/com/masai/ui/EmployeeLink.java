package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.methods.ChangePassword;
import com.masai.methods.GetEmpByID;
import com.masai.methods.UpdateEmpProfile;

public class EmployeeLink {
	
	
	static boolean	flag=true;
	
	public  static void linkingEmployeeMethod(Employee  emp) throws SQLException, DepartmentException, EmployeeException {
		
		Scanner sc = new Scanner(System.in);
			
		System.out.println("============================================");
		System.out.println(" ***Welcome  To   My   Employee   Panel***");
		System.out.println("============================================");
		try {
			System.out.println("Please Choose Options: ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 1 ---> View Your Profile ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 2 ---> Update Your Profile ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 3 ---> Change Password");
			Thread.sleep(300);
			System.out.println("");
			System.out.println("Press 4 ---> Apply For Leaves");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 5 ---> For Home");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 6 ---> Exit");
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		do {
//			try {
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		System.out.print("Option: ");
		int choice=sc.nextInt();
		
		//Options  To Choose

//		switch (choice) {
//			case 1: {
		if(choice==1) {
				System.out.println();
				GetEmpByID.main(emp.getEmpId());
//				break;
			}
		else if(choice==2) {
			    System.out.println();
			    UpdateEmpProfile.main(emp.getEmpId());
//				break;
				}
		else if(choice==3) {
				System.out.println();
				ChangePassword.main(emp.getEmpId());
//				break;
				
			}
		else if(choice==4) {                         //change
				System.out.println();
				ChangePassword.main(emp.getEmpId());
//				break;
				
			}
		else if(choice==5) {
				System.out.println();
				System.out.println("   Application  Closed");
				System.out.println("     Home  Page");
				System.out.println("-------------------------");
				Main.main(null);
				flag=false;
//				break;
			}
		else if(choice==6) {
				System.out.println();
				System.out.println("   Application  Closed");
				System.out.println("     Exit  to  Employee  Panel");
				EmployeeLink.linkingEmployeeMethod(null);
				flag=false;
//				break;
			}
			
		else {
				throw new IllegalArgumentException("Unrelated value: " + choice);
		}
		
//	}while(flag);
		sc.close();
	}
}
