package com.training.jparepository.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.jparepository.model.Employees;
import com.training.jparepository.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public List<Employees> getAllEmployees() {
		return employeeService.getEmployees();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees/create")
	public ResponseEntity<String> addEmployees(@Valid @RequestBody Employees employee) {
		employeeService.addEmployees(employee);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee Added Successfully");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = "name")
	public List<Employees> getAllEmployeesByFirstName(@RequestParam String name) {
		return employeeService.getEmployeesFirstNameIgnoreCase(name);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = { "lname", "email" })
	public List<Employees> getAllEmployeesByLastNameOrEmail(@RequestParam String lname, @RequestParam String email) {
		return employeeService.getEmployeesByLastNameOrEmail(lname, email);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = "email")
	public List<Employees> getAllEmployeesEmailLike(@RequestParam String email) {
		String pattern = "%" + email + "%";
		return employeeService.getEmployeesEmailLike(pattern);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = "gender")
	public List<Employees> getAllEmployeesByGenderStartsWith(@RequestParam String gender) {
		return employeeService.getEmployeesByGenderStartsWith(gender);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{active}/", params = "salary")
	public List<Employees> getAllEmployeesActiveAndSalaryGreaterThan(@PathVariable boolean active,
			@RequestParam int salary) {
		return employeeService.getEmployeesActiveAndSalaryGreaterThan(active, salary);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/salary/{salary}")
	public List<Employees> getTop3EmployeesSalaryLessThan(@PathVariable(value = "salary") int salary) {
		return employeeService.getEmployeesSalaryLessThan(salary);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = "fname")
	public List<Employees> getAllEmployeesFirstNameContainingOrderBySalary(@RequestParam String fname) {
		return employeeService.getEmployeesFirstNameContainingOrderBySalary(fname);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/", params = "hiredate")
	public List<Employees> getAllEmployeesHiredateBefore(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredate) throws ParseException {
		return employeeService.getEmployeesHiredateBefore(hiredate);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{gender}/{hiredate}")
	public List<Employees> getAllEmployeesHiredateAfterAndGender(@PathVariable String gender,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredate) throws ParseException {
		return employeeService.getEmployeesHiredateAfterAndGender(hiredate,
				gender);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/search/{startdate}/{enddate}")
	public List<Employees> getAllEmployeesHiredateBetween(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws ParseException {
		return employeeService.getEmployeesHiredateBetween(startdate,
				enddate);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	public Employees getEmployeeById(@PathVariable(value = "id") Integer id) {
		return employeeService.getEmployee(id);
	}

}
