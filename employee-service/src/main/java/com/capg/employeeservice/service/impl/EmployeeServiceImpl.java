package com.capg.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.entity.Employee;
import com.capg.employeeservice.repository.EmployeeRepository;
import com.capg.employeeservice.services.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert employee dto to JPA entity
		Employee employee = new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	
		Employee savedEmployee = employeeRepository.save(employee);
		
		//convert JPA Entity to Dto
		
		EmployeeDto  savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail()
				);
		
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
		//convert JPA Entity to Dto
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
		return employeeDto;
	}

}
