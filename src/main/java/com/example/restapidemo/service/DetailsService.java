package com.example.restapidemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.repository.EmployeeRepository;

@Component
public class DetailsService {

@Autowired
private EmployeeRepository employeeRepository;	
	
	
public String getStudentName(String id) {
	
	Employee aEmployee=employeeRepository.findById(id).get();
	return aEmployee.getName();
}

public List<Employee> getAllEmployee(){
	List<Employee> empList = (List<Employee>) employeeRepository.findAll();
	return empList;
}
	
}
