package com.example.demo.model;

public class Employee {

	private Integer empId;
	private String empName;
	private Double salary;
	private long phoneNumber;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Employee() {
		super();

	}

	public Employee(Integer empId, String empName, Double salary, long phoneNumber) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
