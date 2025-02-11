package com.prajwal.emp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="emp_db")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="emp_name")
	@NotBlank(message="Name must not be empty!!!")
	private String name;
	
	@Column(name = "emp_designation")
	@NotBlank(message="Designation must not be empty!!!")
	private String designation;
	
	@Column(name = "emp_phoneNo")
	@Size(min = 10,max=10,message = "Invalid phone number!!!")
	private String phone;
	
	@Column(name="emp_email")
	@Email(message="Invalid email address!!!")
	@NotBlank(message="Email must not be empty!!!")
	private String email;
	
	
	@Column(name = "emp_location")
	@NotEmpty(message="Location must not be empty!!!")
	private String location;
	
	
	

}
