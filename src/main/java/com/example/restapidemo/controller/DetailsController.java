package com.example.restapidemo.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.service.DetailsService;

@RestController
public class DetailsController {

	@Autowired
	private DetailsService detailsService;

	@GetMapping(path = "employee/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmployeeDetails(@PathVariable(name = "id") String id) {
//		System.out.println("ID of the student: "+id);
		String name=detailsService.getStudentName(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	
	// Fetch All employee list from postgress remote database
	@GetMapping(path="empList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllEmployees(){
		java.util.List<Employee> empList = detailsService.getAllEmployee();
		System.out.println("Employee List: "+empList);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	
}