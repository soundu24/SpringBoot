package com.capg.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.employeeservice.dto.APIResponseDto;
import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "Employee-Service - EmployeeController",
		description = "Employee Controller Exposes REST APIs for Employee-Service")
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Operation(
			summary = "Save Employee REST API",
			description = "Save Employee REST API is used to save employee object in database"
			)
	
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	
	//Build save employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get employee By REST API",
			description = "Get employee By REST API is used to get a employee object from the database"
			)
	
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	//Build get employee REST API
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
}
