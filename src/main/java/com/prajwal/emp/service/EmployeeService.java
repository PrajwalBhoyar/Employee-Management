package com.prajwal.emp.service;

import java.util.List;

import com.prajwal.emp.entities.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	List<Employee> findByLocation(String location);
	
	List<Employee> findByDesignation(String designation);
	
	Employee updateEmployee(Employee employee, Long id);

	void deleteEmployee(Long id);
}
