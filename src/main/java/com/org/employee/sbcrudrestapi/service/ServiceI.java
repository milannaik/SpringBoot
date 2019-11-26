package com.org.employee.sbcrudrestapi.service;

import java.util.List;
import java.util.Optional;

import com.org.employee.sbcrudrestapi.model.Employee;

public interface ServiceI {
	public List<Employee> getEmployees();
	public Optional<Employee> getEmployeeById(int empid);
	public Employee addNewEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public void deleteEmployeeById(int empid);
	public void deleteAllEmployees();
	
	}
