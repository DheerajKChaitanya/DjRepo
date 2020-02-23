package com.dj.sample.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dj.sample.app.pojo.Employee;
import com.dj.sample.app.pojo.EmployeeList;
import com.dj.sample.app.repository.EmployeeRepository;

@RestController
public class SampleController {

	static List<Employee> empList = new ArrayList<>();

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

	static {
		empList.add(new Employee(123, "Dheeraj", 25000D, 111L));
		empList.add(new Employee(234, "Chaitanya", 15000D, 222L));
		empList.add(new Employee(345, "Ramehs", 20000D, 333L));
		empList.add(new Employee(546, "Suresh", 30000D, 444L));
	}

	@PostMapping("/Employee")
	public Employee addEmployee(@RequestBody Employee emp) {

		// empList.add(emp);
		emp = employeeRepository.save(emp);
		return emp;
	}

	@GetMapping("/Employees")
	public EmployeeList getAllEmployee() {
		EmployeeList employeeList = new EmployeeList();
		employeeList.setEmpList(empList);
		return employeeList;
	}

	@GetMapping("/Employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {

		log.info("Id--" + id);
		for (Employee e : empList) {
			if (id.equals(e.getEmpId())) {
				return e;
			}
		}

		return null;
	}

	@DeleteMapping("/Employees")
	public String deleteEmploye() {

		empList.clear();

		return "Employeed deleted";
	}

	@PutMapping("Employee")
	public Employee updateEmployee(@RequestBody Employee e) {

		for (Employee emp : empList) {
			if (e.getEmpId().equals(emp.getEmpId())) {
				// Employee emp = new Employee()
				emp.setEmpId(e.getEmpId());
				emp.setEmpName(e.getEmpName());
				emp.setPhoneNumber(e.getPhoneNumber());
				emp.setSalary(e.getSalary());
				return emp;
			}
		}

		return null;
	}
}
