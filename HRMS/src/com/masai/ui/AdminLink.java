package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;
import com.masai.methods.AcceptLeave;
import com.masai.methods.AddDepartment;
import com.masai.methods.AddEmployee;
import com.masai.methods.ChangeEmployeeDepartment;
import com.masai.methods.RejectLeave;
import com.masai.methods.UpdateDepartment;
import com.masai.methods.ViewAllDepartment;
import com.masai.methods.ViewAllEmployee;

public class AdminLink {
	
	
	static boolean flag=true;
	
	public  static void linkingAdmin() throws SQLException, DepartmentException, EmployeeException {
		Scanner sc=new Scanner(System.in);

		System.out.println("==========================================");
		System.out.println("    Welcome  To   My   Admin   Panel    ");
		System.out.println("=========================================");
		System.out.println();
		try {
			System.out.println("Please Choose an Option :");
			System.out.println();
			Thread.sleep(300);
			System.out.println("Press 1 ---> Add New Department");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 2 ---> View All Department ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 3 ---> View All Employee ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 4 ---> Update The Department ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 5 ---> Add New Employee ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 6 ---> Transfer Employee To Other Department");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 7 ---> Accept leaves Of Employess");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 8 ---> Reject Leaves Of Employees");
			Thread.sleep(300);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		do {
			try {
				System.out.println("Press 9 ---> For Home ");
				Thread.sleep(300);
				System.out.println();
				System.out.println("Press 10 ---> For Exit ");
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.print("Option: ");
			int choice = sc.nextInt();
		
		//Options  To Choose
			
		switch (choice) {
				case 1: {
						System.out.println();
						AddDepartment.register();
						break;
				}
				case 2: {
						System.out.println();
						ViewAllDepartment.main(null);
						break;
				}
				case 3: {
					System.out.println();
					ViewAllEmployee.main(null);
					break;
				}
				case 4: {
						System.out.println();
						UpdateDepartment.main(null);
						break;
				}
				case 5: {
					System.out.println();
					AddEmployee.main(null);
					break;
				}
				case 6: {        
					System.out.println();
					ChangeEmployeeDepartment.main(null);
					break;
				}
				case 7: {
					System.out.println();
					AcceptLeave.main(null);
					break;
				}
				case 8: {
					System.out.println();
					RejectLeave.main(null);
					break;
				}
				
				case 9: {
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("   Application  Closed");
					System.out.println("        Home  Page");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
					Main.main(null);
					flag=false;
					break;
				}
				case 10: {
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("   Application  Closed");
					System.out.println("   Exit  to  Admin  Panel");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
					AdminLink.linkingAdmin();
					flag=false;
					break;
				}
				default:
						throw new IllegalArgumentException("Unrelated value: " + choice);
		}
		
//		}while(flag);
		sc.close();
	}
}
