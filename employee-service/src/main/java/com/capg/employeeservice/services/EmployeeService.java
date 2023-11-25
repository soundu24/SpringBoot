package com.capg.employeeservice.services;

import com.capg.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);

}
