package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Leaves;
import com.masai.dto.LeavesImpl;
import com.masai.exception.LeaveException;

public class LeavesDaoImpl implements LeavesDao{

	@Override
	public String requestLeave(int id) throws LeaveException {
		Connection conn=null;
		String message="";
		try {
			conn=DBUtils.createConnection();
			
			String query="insert into leaves (status,empId) values('pending',?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			int res=ps.executeUpdate();
			
			if(res>0) {
				message="Successfully Applied for Leave";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String approveLeave(int id) throws LeaveException {
		Connection conn=null;
		String message="";
		try {
			conn=DBUtils.createConnection();
			
			String query="update leaves set status='Accepted' where empid=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			int res=ps.executeUpdate();
			
			if(res>0) {
				message="Leave Approved";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String rejectLeave(int id) throws LeaveException {
		Connection conn=null;
		String message="";
		try {
			conn=DBUtils.createConnection();
			
			String query="update leaves set status='Rejected' where empid=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			int res=ps.executeUpdate();
			
			if(res>0) {
				message="Leave Rejected";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public List<Leaves> pendingLeaves() throws LeaveException {
		List<Leaves> list=new ArrayList<>();
		Connection conn=null;
		
		try {
			conn=DBUtils.createConnection();
			String query="select l.status, l.empId from leaves l inner join  employee e on e.empId=l.empId and status=null";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Leaves leave=new LeavesImpl();
				leave.setEmployeeId(rs.getInt("empid"));
				leave.setName(rs.getString("name"));
				leave.setDepartmentID(rs.getInt("departmentid"));
				leave.setStatus(rs.getString("status"));
				list.add(leave);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
