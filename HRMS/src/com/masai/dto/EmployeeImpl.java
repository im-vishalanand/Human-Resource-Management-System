package com.masai.dto;

public class EmployeeImpl implements Employee{

	private int empId;
	private String empName;
	private String empUsername;
	private String empPassword;
	private int empDid;
	
	public EmployeeImpl(){}

	public EmployeeImpl(int empId, String empName, String empUsername, String empPassword, int empDid) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empDid = empDid;
	}
	
	public EmployeeImpl(String empName, String empUsername, String empPassword, int empDid) {
		super();
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empDid = empDid;
	}

	@Override
	public int getEmpId() {
		return empId;
	}
	@Override
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String getEmpName() {
		return empName;
	}
	@Override
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String getEmpUsername() {
		return empUsername;
	}
	@Override
	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	@Override
	public String getEmpPassword() {
		return empPassword;
	}
	@Override
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public int getEmpDid() {
		return empDid;
	}
	@Override
	public void setEmpDid(int empDid) {
		this.empDid = empDid;
	}

	@Override
	public String toString() {
		return "EmployeeImpl [empId=" + empId + ", empName=" + empName + ", empUsername=" + empUsername
				+ ", empPassword=" + empPassword + ", empDid=" + empDid + "]";
	}
	
}
