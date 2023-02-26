package com.masai.dao;

import java.util.List;

import com.masai.dto.Leaves;
import com.masai.exception.LeaveException;

public interface LeavesDao {

	public String requestLeave(int id) throws LeaveException;
	public String approveLeave(int id) throws LeaveException;
	public String rejectLeave(int id) throws LeaveException;
	public List<Leaves> pendingLeaves() throws LeaveException;
}
