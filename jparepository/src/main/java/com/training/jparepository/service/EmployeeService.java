package com.training.jparepository.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jparepository.exception.ResourceAlreadyExistsException;
import com.training.jparepository.exception.ResourceNotFoundException;
import com.training.jparepository.exception.StartEndDateException;
import com.training.jparepository.model.Employees;
import com.training.jparepository.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employees getEmployee(int id) {
		return Optional.ofNullable(employeeRepository.findById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with Id" + id));
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
		if(start.after(end)) {
			throw new StartEndDateException("Invalid Dates");
		}
		return employeeRepository.findByHiredateBetween(start, end);
	}

	public Employees addEmployees(Employees employee) {
		if(employeeRepository.findByEmail(employee.getEmail()).isPresent())
			throw new ResourceAlreadyExistsException("Email Already Taken");
		return employeeRepository.save(employee);
	}

}
