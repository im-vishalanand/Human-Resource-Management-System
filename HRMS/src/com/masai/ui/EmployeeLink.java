package com.masai.ui;

import java.util.Scanner;

import com.masai.methods.ApplyLeave;
import com.masai.methods.ChangePassword;
import com.masai.methods.GetEmpByID;
import com.masai.methods.UpdateEmpProfile;

public class EmployeeLink {
	
	
	static boolean	flag=true;
	
	public  static void linkingEmployeeMethod() {
		
		Scanner sc = new Scanner(System.in);
		int choice=0;
			
		System.out.println("============================================");
		System.out.println("    Welcome  To   My   Employee   Panel   ");
		System.out.println("============================================");
		try {
			System.out.println();
			System.out.println("Please Choose an Option: ");
			Thread.sleep(300);
			System.out.println();
			System.out.println("Press 1 ---> View Your Profile ");
			Thread.sleep(300);
			System.out.println("Press 2 ---> Update Your Profile ");
			Thread.sleep(300);
			System.out.println("Press 3 ---> Change Password");
			Thread.sleep(300);
			System.out.println("Press 4 ---> Apply For Leaves");
			Thread.sleep(300);
			System.out.println("Press 5 ---> For Home");
			Thread.sleep(300);
			System.out.println("Press 6 ---> Exit");
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println();
		}
		System.out.println();
		System.out.print("Option: ");
		choice=sc.nextInt();

		//------------------------Options To Choose----------------------------

		if(choice==1) {
				System.out.println();
				GetEmpByID.main();
			}
		else if(choice==2) {
			    System.out.println();
			    int e=Main.empId;
			    UpdateEmpProfile.main(e);
				}
		else if(choice==3) {
				System.out.println();
				int e=Main.empId;
				ChangePassword.main(e);				
			}
		else if(choice==4) {                         //change
				System.out.println();
				int e=Main.empId;
				ApplyLeave.main(e);			
			}
		else if(choice==5) {
				System.out.println();
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("   Back to Home  Page");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
				Main.main(null);
			}
		else if(choice==6) {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("   Application  Closed");
				System.out.println("  Thank You For Visiting");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			}
		else {
			System.out.println("Wrong Selection");
			System.out.println();
			linkingEmployeeMethod();
		}
		
	}
}
