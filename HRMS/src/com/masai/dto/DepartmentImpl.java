package com.masai.dto;

public class DepartmentImpl implements Department{

	private int deptNo;
	private String deptName;
	
	public DepartmentImpl(){}

	public DepartmentImpl(String deptName, int deptNo) {
		this.deptName = deptName;
		this.deptNo = deptNo;
	}

	@Override
	public String getDeptName() {
		return deptName;
	}
	@Override
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public int getDeptNo() {
		return deptNo;
	}
	@Override
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "DepartmentImpl [deptName=" + deptName + ", deptNo=" + deptNo + "]";
	}
}
