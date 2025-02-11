package com.prajwal.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.emp.entities.Employee;
import com.prajwal.emp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmpController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee( @Valid  @RequestBody Employee employee) {
		Employee createEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getallEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(allEmployees);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employeeById = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employeeById, HttpStatus.FOUND);
	}
	
	@GetMapping("/employees/location")
	public ResponseEntity<List<Employee>> findByLocation(@RequestParam String location) {
		List<Employee> employees = employeeService.findByLocation(location);
		return ResponseEntity.ok(employees);
	}	
	
	@GetMapping("/employees/designation")
	public ResponseEntity<List<Employee>> findByDesignation(@RequestParam String designation) {
		List<Employee> employees = employeeService.findByDesignation(designation);
		return ResponseEntity.ok(employees);
	}
	

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable long id) {
		Employee updatedEmployee = employeeService.updateEmployee(employee, id);

		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully for id: " + id);
	}

}
