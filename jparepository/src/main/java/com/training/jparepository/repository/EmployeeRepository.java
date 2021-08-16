package com.training.jparepository.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.jparepository.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>{
	Employees findById(int id);
	
	/**
	 * 
	 * @param salary
	 * @return Employees whose salary is greater than and Equal to @salary
	 */
	
	List<Employees> findBySalaryGreaterThanEqual(int salary);
	
	/**
	 * 
	 * @param pattern
	 * @return Employees whose email id is like pattern
	 */
	
	List<Employees> findByEmailLike(String pattern);
	
	/**
	 * 
	 * @param date
	 * @return Employees whose joined before the date
	 */
	List<Employees> findByHiredateBefore(Date date);
	
	List<Employees> findByHiredateAfterAndGender(Date date, String gender);
	
	List<Employees> findDistinctTop3BySalaryLessThan(int salary);

	List<Employees> findByActiveAndSalaryGreaterThan(boolean active, int salary);	
	
	List<Employees> findByFirstNameIgnoreCase(String name);
	
	List<Employees> findByFirstNameContainingOrderBySalaryAsc(String name);
	
	List<Employees> findByGenderStartsWithIgnoreCase(String prefix);

	List<Employees> findByLastNameOrEmailAllIgnoreCase(String name, String email);

	List<Employees> findByHiredateBetween(Date start, Date end);
	
	Optional<Employees> findByEmail(String email);
	



}
