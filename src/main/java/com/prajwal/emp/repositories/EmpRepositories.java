package com.prajwal.emp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajwal.emp.entities.Employee;

@Repository
public interface EmpRepositories extends JpaRepository<Employee, Long>{
	List<Employee> findByLocation(String location);
	List<Employee> findByDesignation(String designation);
}
