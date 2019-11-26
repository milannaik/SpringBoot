package com.org.employee.sbcrudrestapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	@Column(name = "first_name")
	@NotEmpty(message = "first name must not be empty")
	private String firstName;
	@Column(name = "last_name")
	@NotEmpty(message = "last name must not be empty")
	private String lastName;
	@Column(name = "position")
	@NotEmpty(message = "position must not be empty")
	private String role;
	@Column(name = "date_of_joining")
	private Date dateOfJoinig;
	@Column(name = "salary")
	private int salary;

	public Employee() {

	}

	public Employee(int empid, String firstName, String lastName, String role, Date dateOfJoinig, int salary) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.dateOfJoinig = dateOfJoinig;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateOfJoinig() {
		return dateOfJoinig;
	}

	public void setDateOfJoinig(Date dateOfJoinig) {
		this.dateOfJoinig = dateOfJoinig;
	}

	public int getSalaray() {
		return salary;
	}

	public void setSalaray(int salaray) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", dateOfJoinig=" + dateOfJoinig + ", salaray=" + salary + "]";
	}

}
