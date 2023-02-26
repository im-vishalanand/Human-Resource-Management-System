package com.masai.methods;

import java.util.Scanner;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.exception.LeaveException;

public class RejectLeave {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		LeavesDao l=new LeavesDaoImpl();
		String res;
		try {
			res = l.rejectLeave(id);
			System.out.println(res);
			
		} catch (LeaveException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
