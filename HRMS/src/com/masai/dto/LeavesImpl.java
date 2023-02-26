package com.masai.dto;

public class LeavesImpl implements Leaves{

	int employeeId;
	String name;
	int departmentID;
	String status;
	
	public LeavesImpl() {
		super();
	}

	public LeavesImpl(int employeeId, String name, int departmentID, String status) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.departmentID = departmentID;
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeavesImpl [employeeId=" + employeeId + ", name=" + name + ", departmentID=" + departmentID
				+ ", status=" + status + "]";
	}
	
	
	
}
