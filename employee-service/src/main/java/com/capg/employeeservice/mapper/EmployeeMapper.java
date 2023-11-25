package com.capg.employeeservice.mapper;

import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.entity.Employee;

public class EmployeeMapper {

	//convert EmployeeDto to JPA entity
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
	Employee employee = new Employee(
			employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail()
			);
	return employee;
	}
	//convert employee JPA entity into employeeDto
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		EmployeeDto  employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
		return employeeDto;
	}
}
	
