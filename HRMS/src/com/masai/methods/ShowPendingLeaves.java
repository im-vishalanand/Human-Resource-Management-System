package com.masai.methods;

import java.util.List;

import com.masai.dao.LeavesDao;
import com.masai.dao.LeavesDaoImpl;
import com.masai.dto.Leaves;
import com.masai.exception.LeaveException;

public class ShowPendingLeaves {

	public static void main(String[] args) {
		LeavesDao leave=new LeavesDaoImpl();
		
		try {
			List<Leaves> list=leave.pendingLeaves();
			
			list.forEach(e->{
				System.out.println("Employee ID is : "+ e.getEmployeeId());
				System.out.println("Department name is : "+e.getName());
				System.out.println("Department name is : "+e.getDepartmentID());
				System.out.println("Department status is : "+e.getStatus());
				
				System.out.println("=====================================");
			});
		} catch (LeaveException e) {
			e.printStackTrace();
		}
		
		

	}

}
