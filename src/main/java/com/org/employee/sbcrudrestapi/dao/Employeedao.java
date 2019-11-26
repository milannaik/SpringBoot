package com.org.employee.sbcrudrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.employee.sbcrudrestapi.model.Employee;

@Repository
public interface Employeedao extends JpaRepository<Employee, Integer> {
	public List<Employee> findBySalaryGreaterThan(int salary);
	}
