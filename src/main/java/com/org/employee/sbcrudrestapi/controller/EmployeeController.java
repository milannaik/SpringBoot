package com.org.employee.sbcrudrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.sbcrudrestapi.model.Employee;
import com.org.employee.sbcrudrestapi.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

    //get all the employees
	@RequestMapping(value = "/employee/all", produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	@GetMapping
	public List<Employee> getEmployees() {
		System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
		return service.getEmployees();
	}

    //get employee by id
	@RequestMapping(value = "/employee/{empid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@GetMapping
	public Employee getById(@PathVariable int empid) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");
		Optional<Employee> emp = service.getEmployeeById(empid);
		if (!emp.isPresent())// Java 8 feature
			throw new Exception("Could not find employee for id:- " + empid);

		return emp.get();
	}

    //create a new employee
	@RequestMapping(value = "/employee/add1", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@PostMapping
	public Employee create(@Valid @RequestBody Employee emp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
		return service.addNewEmployee(emp);
	}
    //Update Employee
	@RequestMapping(value = "/employee1/{empid}")
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee updemp, @PathVariable int empid) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");

		Optional<Employee> emp = service.getEmployeeById(empid);
		if (!emp.isPresent())
			throw new Exception("Could not find employee with id- " + empid);
		/*
		 * IMPORTANT - To prevent the overriding of the existing value of the variables
		 * in the database, if that variable is not coming in the @RequestBody
		 * annotation object.
		 */
		if (updemp.getFirstName() == null || updemp.getFirstName().isEmpty()) {
			updemp.setFirstName(emp.get().getFirstName());
			System.out.print("updemp" + emp.get().getFirstName());
		}
		if (updemp.getLastName() == null || updemp.getLastName().isEmpty())
			updemp.setLastName(emp.get().getLastName());
		if (updemp.getRole() == null || updemp.getRole().isEmpty())
			updemp.setRole(emp.get().getRole());
		if (updemp.getDateOfJoinig() == null || updemp.getRole().isEmpty())
			updemp.setDateOfJoinig(emp.get().getDateOfJoinig());
		updemp.setEmpid(empid);
		return service.updateEmployee(updemp);
	}
    //Delete emp
	@RequestMapping(value = "/employee/delete/{id}")
	@DeleteMapping
	public void deleteEmployeeById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");

		Optional<Employee> emp = service.getEmployeeById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find employee with id- " + id);

		service.deleteEmployeeById(id);
	}
	//delete all employees
	@RequestMapping(value= "/employee/deleteall")
	@DeleteMapping
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all employees is invoked.");
		service.deleteAllEmployees();
	}
	
	@RequestMapping(value= "/employee/sal/{salaray}")
	@GetMapping
	public List getEmployeeBySalary(@PathVariable int salaray) {
		System.out.println(this.getClass().getSimpleName() + " - Employee by sal is invoked.");
		return service.getEmployeeBySal(salaray);
	}
	@RequestMapping(value= "/employee/sal1/{salary}")
	@GetMapping
	public List<Employee> getEmployeeBySalary1(@PathVariable int salary) {
		System.out.println(this.getClass().getSimpleName() + " - Employee by sal is invoked.");
		return service.getEmployeeBySalaray1(salary);
	}
}
