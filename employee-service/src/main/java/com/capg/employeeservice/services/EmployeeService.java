package com.capg.employeeservice.services;

import com.capg.employeeservice.dto.APIResponseDto;
import com.capg.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployeeById(Long employeeId);

}
