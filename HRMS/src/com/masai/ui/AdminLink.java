package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.exception.DepartmentException;
import com.masai.exception.LeaveException;
import com.masai.useCase.AcceptLeave;
import com.masai.useCase.AddDepartmentUsecase;
import com.masai.useCase.AddEmployeeUserCase;
import com.masai.useCase.UpdateDepartmentUsecase;
import com.masai.useCase.ViewAllDepartmentUseCase;
import com.masai.useCase.ViewAllEmployee;

public class AdminLink {
	
	
	static boolean	flag=true;
	
	public  static void linkingAdmin() throws SQLException {
		Scanner sc=new Scanner(System.in);
//		do {
			System.out.println("==========================================");
			System.out.println( " ***Welcome  To   My   Admin   Panel***");
			System.out.println( "=========================================");
			System.out.println();
			try {
				System.out.println("               Please Choose Options               ");
				Thread.sleep(300);
				System.out.println("Press 1 ---> For Adding New Departments");
				Thread.sleep(300);
				System.out.println();
				System.out.println("Press 2 ---> View all Department ");
				Thread.sleep(300);
				System.out.println();
				System.out.println("Press 3 ---> View all Employee ");
				Thread.sleep(300);
				System.out.println();
				System.out.println("Press 4 ---> Update The Department ");
				Thread.sleep(300);
				System.out.println();
				System.out.println("Press 5 ---> For Adding New Employees ");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			do {
				try {
					System.out.println("Press 9 ---> For Home ");
					Thread.sleep(300);
					System.out.println();
					System.out.println("Press 10 ---> For Exit ");
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			System.out.print("Option: ");
			int choice = sc.nextInt();
			
			//---------------------------------------------Options  To Choose--------------------------------------
			switch (choice) {
					case 1: {
							System.out.println();
							try {
								AddDepartmentUsecase.register();
							} catch (DepartmentException e) {
								e.printStackTrace();
							}
							break;
					}
					case 2: {
							System.out.println();
							ViewAllDepartmentUseCase.main(null);
							break;
					}
					case 3: {
						System.out.println();
						ViewAllEmployee.main(null);
						break;
				}
					case 4: {
							System.out.println();
							try {
								UpdateDepartmentUsecase.main(null);
							} catch (DepartmentException e) {
								e.printStackTrace();
							}
							break;
					}
					case 5: {
						System.out.println();
						AddEmployeeUserCase.main(null);
						break;
					}
					
					case 7: {
						System.out.println();
						try {
							AcceptLeave.main(null);
						} catch (LeaveException e) {
							e.printStackTrace();
						}
						break;
					}
					
					case 9: {
						System.out.println();
						System.out.println("   Application  Closed");
						System.out.println("     Home  Page");
						System.out.println("-------------------------");
						Main.main(null);
						flag=false;
						break;
					}
					case 10: {
						System.out.println();
						System.out.println("   Application  Closed");
						System.out.println("     Exit  to  Admin  Panel");
						System.out.println("-------------------------");
						AdminLink.linkingAdmin();
						flag=false;
						break;
					}
					default:
							throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			
			}while(flag);
	}
}
