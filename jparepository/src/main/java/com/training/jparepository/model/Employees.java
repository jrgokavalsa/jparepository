package com.training.jparepository.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employees {
	
	@Id
	@JsonIgnore
	private int empid;
	
	@NotBlank(message = "First Name cannot be Blank")
	private String firstName;
	@NotBlank(message = "Last Name cannot be Blank")
	private String lastName;
	@NotBlank(message = "Email cannot be Blank")
	@Email(message = "Invalid Format")
	private String email;
	@NotBlank(message = "Gender cannot be Blank")
	private String gender;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date hiredate;
	@NotBlank(message = "Active cannot be Blank")
	private boolean active;
	@Min(value = 3000, message = "Salary should be greater than 3000")
	@Max(value = 50000,message = "Salary should be less than 50000")
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
