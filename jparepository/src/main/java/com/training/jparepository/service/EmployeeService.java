package com.training.jparepository.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jparepository.model.Employees;
import com.training.jparepository.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employees getEmployee(int id) {
		System.out.println(id);
		return employeeRepository.findById(id);
	}

	public List<Employees> getEmployees() {
		return employeeRepository.findAll();
	}

	public List<Employees> getEmployeesEmailLike(String pattern) {
		return employeeRepository.findByEmailLike(pattern);
	}

	public List<Employees> getEmployeesSalaryLessThan(int salary) {
		return employeeRepository.findDistinctTop3BySalaryLessThan(salary);
	}

	public List<Employees> getEmployeesActiveAndSalaryGreaterThan(boolean active, int salary) {
		return employeeRepository.findByActiveAndSalaryGreaterThan(active, salary);
	}

	public List<Employees> getEmployeesFirstNameIgnoreCase(String name) {
		return employeeRepository.findByFirstNameIgnoreCase(name);
	}

	public List<Employees> getEmployeesByGenderStartsWith(String gender) {
		return employeeRepository.findByGenderStartsWithIgnoreCase(gender);
	}

	public List<Employees> getEmployeesByLastNameOrEmail(String lname, String email) {
		return employeeRepository.findByLastNameOrEmailAllIgnoreCase(lname, email);
	}

	public List<Employees> getEmployeesFirstNameContainingOrderBySalary(String name) {
		return employeeRepository.findByFirstNameContainingOrderBySalaryAsc(name);
	}

	public List<Employees> getEmployeesHiredateBefore(Date hiredate) {
		return employeeRepository.findByHiredateBefore(hiredate);
	}

	public List<Employees> getEmployeesHiredateAfterAndGender(Date hiredate, String gender) {
		return employeeRepository.findByHiredateAfterAndGender(hiredate, gender);
	}

	public List<Employees> getEmployeesHiredateBetween(Date start, Date end) {
		return employeeRepository.findByHiredateBetween(start,end);
	}

}
