package com.org.employee.sbcrudrestapi.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.employee.sbcrudrestapi.dao.Employeedao;
import com.org.employee.sbcrudrestapi.exception.EmployeeNotFoundException;
import com.org.employee.sbcrudrestapi.model.Employee;

@Service
public class EmployeeService implements ServiceI {

	@Autowired
	Employeedao dao;

	// get list of employees;
	@Override
	public List<Employee> getEmployees() {
		return dao.findAll();
	}

	// get employee by id
	@Override
	public Optional<Employee> getEmployeeById(int empid) {
	return dao.findById(empid);
	}

	// add new employee
	@Override
	public Employee addNewEmployee(Employee emp) {
		return dao.save(emp);
	}

	// udate employee by id
	@Override
	public Employee updateEmployee(Employee emp) {
		return dao.save(emp);
	}

	// delete employee by id
	@Override
	public void deleteEmployeeById(int empid) {
		dao.deleteById(empid);
	}

	// delete all employees
	@Override
	public void deleteAllEmployees() {
		dao.deleteAll();
	}

	public List getEmployeeBySal(int salaray)
	{
		
		  int sal; 
		  sal=salaray;
		 
		/*
		 * List<Integer> emp=(List<Integer>) dao.findAll().stream()
		 * .filter(s->s.getSalaray()>sal) .map(s->s.getSalaray())
		 * .collect(Collectors.toList()); System.out.print("list of employees"+emp);
		 */
		System.out.print("list of employees");
		List<Employee> al=new ArrayList<Employee>();
		 al= dao.findAll().stream() 
		  .filter(s->s.getSalaray()>sal)
				/* .map(s->s.getFirstName()) */
		  .collect(Collectors.toList()) ; 
				  //System.out.print("list of employees");
		
		 return al;
		
		/*
		 * List<Employee> list1 = dao.findBySalaryGreaterThan(sal);
		 * list1.stream().forEach(System.out::println); return (List<Employee>) list1;
		 */
	}


	public List<Employee> getEmployeeBySalaray1(int salary) {
		// TODO Auto-generated method stub
		return dao.findBySalaryGreaterThan(salary);
	}

	

		
}
