package com.masai.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dto.EmployeeImpl;
import com.masai.exception.EmployeeException;
import com.masai.useCase.ChangePassword;
import com.masai.useCase.GetEmpByID;
import com.masai.useCase.UpdateEmpProfile;

public class EmployeeLink {
	
	
	static boolean	flag=true;
	
	public  static void linkingEmployeeMethod(EmployeeImpl  emp) throws SQLException {
			
			Scanner sc = new Scanner(System.in);
			
				System.out.println();
				System.out.println("=============================================");
				System.out.println( " ***Welcome  To   My   Employee   Panel***");
				System.out.println( "============================================");
				System.out.println();
				
				try {
					System.out.println();
					System.out.println("Please Choose Options: ");
					Thread.sleep(300);
					System.out.println();
					System.out.println("Press 1 . View Your Profile ");
					Thread.sleep(300);
					System.out.println();
					System.out.println("Press 2 . for Update Profile ");
					Thread.sleep(300);
					System.out.println();
					System.out.println("Press 3 . Change Password");
					Thread.sleep(300);
					System.out.println("");
					System.out.println("Press 4 . Apply For Leaves");
					Thread.sleep(300);
					System.out.println();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				do {
						try {
							System.out.println("Press 5 . Home  Page");
							Thread.sleep(300);
							System.out.println();
							System.out.println("Press 6 . Exit");
							Thread.sleep(300);
							System.out.println();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				
				System.out.print("Option: ");
				int choice=sc.nextInt();
				
				switch (choice) {
					case 1: {
						System.out.println();
						GetEmpByID.main(emp.getEmpId());
					break;
					}
					case 2: {
					    System.out.println();
						try {
							UpdateEmpProfile.main(emp.getEmpId());
						} catch (EmployeeException e) {
							e.printStackTrace();
						}
						break;
						}
					case 3: {
						System.out.println();
						ChangePassword.main(emp.getEmpId());
						break;
						
					}
					case 4: {                         //change
						System.out.println();
						ChangePassword.main(emp.getEmpId());
						break;
						
					}
					case 5: {
						System.out.println();
						System.out.println("   Application  Closed");
						System.out.println("     Home  Page");
						System.out.println("-------------------------");
						Main.main(null);
						flag=false;
						break;
					}
					case 6: {
						System.out.println();
						System.out.println("   Application  Closed");
						System.out.println("     Exit  to  Employee  Panel");
						System.out.println();
						System.out.println("     HAVE  A  NICE  DAY");
						System.out.println("-------------------------");
						EmployeeLink.linkingEmployeeMethod(null);
						flag=false;
						break;
					}
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
				}
				
			}while(flag);
		}
}
