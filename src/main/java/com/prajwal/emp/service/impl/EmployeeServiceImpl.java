package com.prajwal.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajwal.emp.entities.Employee;
import com.prajwal.emp.exceptions.ResourceNotFoundException;
import com.prajwal.emp.repositories.EmpRepositories;
import com.prajwal.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmpRepositories empRepositories;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = empRepositories.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = empRepositories.findAll();
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return empRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

	}

	@Override
	public List<Employee> findByLocation(String location) {
		List<Employee> employees = empRepositories.findByLocation(location);

		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "location", location);
		}

		return employees;

	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		List<Employee> employees = empRepositories.findByDesignation(designation);

		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "designation", designation);
		}

		return employees;
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee emp = empRepositories.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		emp.setName(employee.getName());
		emp.setDesignation(employee.getDesignation());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
		emp.setLocation(employee.getLocation());
		return emp;
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee emp = empRepositories.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		empRepositories.delete(emp);

	}

}