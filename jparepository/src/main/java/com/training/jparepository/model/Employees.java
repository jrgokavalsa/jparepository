package com.training.jparepository.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employees {
	
	@Id
	private int empid;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Date hiredate;
	private boolean active;
	private int salary;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employees(int empid, String firstName, String lastName, String email, String gender, Date hiredate,
			boolean active, int salary) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.hiredate = hiredate;
		this.active = active;
		this.salary = salary;
	}
	public Employees() {
	}
	@Override
	public String toString() {
		return "Employees [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", hiredate=" + hiredate + ", active=" + active + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
}
