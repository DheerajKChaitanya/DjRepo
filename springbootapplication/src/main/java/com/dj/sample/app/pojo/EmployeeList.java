package com.dj.sample.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList implements Serializable {

	private static final long serialVersionUID = 719299503813388971L;
	private List<Employee> empList;

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public EmployeeList() {
		super();
		empList = new ArrayList<>();
	}

}
