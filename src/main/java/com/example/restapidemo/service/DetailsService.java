package com.example.restapidemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.repository.EmployeeRepository;

@Component
public class DetailsService {

@Autowired
private EmployeeRepository employeeRepository;	
	
// Save Employee
public Employee saveEmployee(Employee emp) {
	employeeRepository.save(emp);
	return emp;
}

// Get Employee
public Employee getEmployee(String id) {
	return employeeRepository.findById(id).get();
}

public Employee updateEmployee(Employee emp) {
	employeeRepository.save(emp);
	return emp;
}

public String getStudentName(String id) {	
	Employee aEmployee=employeeRepository.findById(id).get();
	return aEmployee.getName();
}

public List<Employee> getAllEmployee(){
	List<Employee> empList = (List<Employee>) employeeRepository.findAll();
	return empList;
}

public String deleteEmployee(String id) {
	employeeRepository.deleteById(id);
	return "";
}
	
}
