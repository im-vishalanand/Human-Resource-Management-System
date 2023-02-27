package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.methods.AcceptLeave;
import com.masai.methods.AddDepartment;
import com.masai.methods.AddEmployee;
import com.masai.methods.ChangeEmployeeDepartment;
import com.masai.methods.DeleteDepartment;
import com.masai.methods.RejectLeave;
import com.masai.methods.UpdateDepartment;
import com.masai.methods.ViewAllDepartment;
import com.masai.methods.ViewAllEmployee;

public class AdminLink {
	
	
	static boolean flag=true;
	
	public  static void linkingAdmin() throws SQLException, DepartmentException, EmployeeException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		System.out.println("=========================================");
		System.out.println("    Welcome  To   My   Admin   Panel    ");
		System.out.println("=========================================");
		System.out.println();
		
		try {
			System.out.println("Please Choose an Option :");
			System.out.println();
			Thread.sleep(300);
			System.out.println("Press 1 ---> Add New Department");
			Thread.sleep(300);
			System.out.println("Press 2 ---> View All Department ");
			Thread.sleep(300);
			System.out.println("Press 3 ---> View All Employee ");
			Thread.sleep(300);
			System.out.println("Press 4 ---> Update The Department ");
			Thread.sleep(300);
			System.out.println("Press 5 ---> Add New Employee ");
			Thread.sleep(300);
			System.out.println("Press 6 ---> Transfer Employee To Other Department");
			Thread.sleep(300);
			System.out.println("Press 7 ---> Accept Leaves Of Employees");
			Thread.sleep(300);
			System.out.println("Press 8 ---> Reject Leaves Of Employees");
			Thread.sleep(300);
			System.out.println("Press 9 ---> Delete a Department");
			Thread.sleep(300);
			System.out.println("Press 10 ---> Home ");
			Thread.sleep(300);
			System.out.println("Press 11 ---> Exit ");
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Wrong Selection");
			linkingAdmin();
		}
		System.out.println();
		System.out.print("Option: ");
		int choice=0;
		try {
			choice =sc.nextInt();			
		}
		catch(Exception e) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("Wrong input. Please Choose a Correct Option");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			linkingAdmin();
		}
		System.out.println();
		
		//-------------------------Options  To Choose-------------------------------------------
			
			if(choice==1) {
						System.out.println();
						AddDepartment.register();
				}
			else if(choice==2) {
				System.out.println();
				ViewAllDepartment.main(null);
				}
			else if(choice==3) {
				System.out.println();
				ViewAllEmployee.main(null);
				}
			else if(choice==4) {
				System.out.println();
				UpdateDepartment.main(null);
				}
			else if(choice==5) {
				System.out.println();
				AddEmployee.main(null);
				}
			else if(choice==6) {        
				System.out.println();
				ChangeEmployeeDepartment.main(null);
				}
			else if(choice==7) {
				System.out.println();
				AcceptLeave.main(null);
				}
			else if(choice==8) {
				System.out.println();
				System.out.print("Enter Employee Id: ");
				int ch=sc.nextInt();
				System.out.println();
				RejectLeave.main(ch);;
				}
			else if(choice==9) {
				System.out.println();
				DeleteDepartment.delete();
			}
				
			else if(choice==10) {
				System.out.println();
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("   Back to Home  Page");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
				Main.main(null);
				}
			else if(choice==11) {
				System.out.println();
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("   Application  Closed");
				System.out.println("  Thank You For Visiting");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				}
			else {
				System.out.println("Wrong selection");
				System.out.println();
				linkingAdmin();
		}
	}
}
