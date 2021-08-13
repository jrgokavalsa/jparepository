package com.training.jparepository.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Employees> getAllEmployeesHiredateBefore(@RequestParam String hiredate) throws ParseException {
		return employeeService.getEmployeesHiredateBefore(new SimpleDateFormat("yyyy-MM-dd").parse(hiredate));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{gender}/{hiredate}")
	public List<Employees> getAllEmployeesHiredateAfterAndGender(@PathVariable String gender,
			@PathVariable String hiredate) throws ParseException {
		return employeeService.getEmployeesHiredateAfterAndGender(new SimpleDateFormat("yyyy-MM-dd").parse(hiredate),
				gender);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{startdate}/{enddate}")
	public List<Employees> getAllEmployeesHiredateBetween(@PathVariable String startdate, @PathVariable String enddate)
			throws ParseException {
		return employeeService.getEmployeesHiredateBetween(new SimpleDateFormat("yyyy-MM-dd").parse(startdate),
				new SimpleDateFormat("yyyy-MM-dd").parse(enddate));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	public Employees getEmployeeById(@PathVariable(value = "id") Integer id) {
		return employeeService.getEmployee(id);
	}

}
