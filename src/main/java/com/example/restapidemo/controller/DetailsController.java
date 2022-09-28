package com.example.restapidemo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.service.DetailsService;

@RestController
public class DetailsController {

	@Autowired
	private DetailsService detailsService;
	
	// Create Employee
	@GetMapping(path = "save/{name}/{rollnumber}/{address}/{mobileNumber}/{pincode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveEmployee(@PathVariable(name = "name") String name,
											   @PathVariable(name = "rollnumber") String rollnumber,
											   @PathVariable(name = "address") String address,
											   @PathVariable(name = "mobileNumber") String mobileNumber,
											   @PathVariable(name = "pincode") String pincode ){
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setRollnumber(rollnumber);
		emp.setAddress(address);
		emp.setMobileNumber(mobileNumber);
		emp.setPincode(pincode);
		detailsService.saveEmployee(emp);
		System.out.println("Employee Created: "+emp.getName());
		java.util.List<Employee> empList = detailsService.getAllEmployee();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	// Fetch All employee list from postgress remote database
	@GetMapping(path="empList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllEmployees(){
		java.util.List<Employee> empList = detailsService.getAllEmployee();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	// Update Employee
	@GetMapping(path = "update/{name}/{rollnumber}/{address}/{mobileNumber}/{pincode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateEmployee(
			   @PathVariable(name = "name") String name,
			   @PathVariable(name = "rollnumber") String rollnumber,
			   @PathVariable(name = "address") String address,
			   @PathVariable(name = "mobileNumber") String mobileNumber,
			   @PathVariable(name = "pincode") String pincode ){
		System.out.println("Enetered inside: "+rollnumber);
		Employee emp = detailsService.getEmployee(rollnumber);
		emp.setName(name);
		emp.setRollnumber(rollnumber);
		emp.setAddress(address);
		emp.setMobileNumber(mobileNumber);
		emp.setPincode(pincode);
		System.out.println("Employee RollNo: "+emp.getRollnumber());
		detailsService.updateEmployee(emp);
		java.util.List<Employee> empList = detailsService.getAllEmployee();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	// Delete Employee
	@GetMapping(path="delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable(name = "id") String id){
		detailsService.deleteEmployee(id);
		java.util.List<Employee> empList = detailsService.getAllEmployee();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	
	@GetMapping(path = "employee/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmployeeDetails(@PathVariable(name = "id") String id) {
    //		System.out.println("ID of the student: "+id);
		String name=detailsService.getStudentName(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}


}