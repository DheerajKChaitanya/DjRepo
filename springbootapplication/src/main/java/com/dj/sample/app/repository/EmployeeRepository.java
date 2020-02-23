package com.dj.sample.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dj.sample.app.pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
