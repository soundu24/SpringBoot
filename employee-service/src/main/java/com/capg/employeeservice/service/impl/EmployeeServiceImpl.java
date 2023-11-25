package com.capg.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.entity.Employee;
import com.capg.employeeservice.mapper.AutoEmployeeMapper;
import com.capg.employeeservice.mapper.EmployeeMapper;
import com.capg.employeeservice.repository.EmployeeRepository;
import com.capg.employeeservice.services.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert employee dto to JPA entity
//		Employee employee = new Employee(
//				employeeDto.getId(),
//				employeeDto.getFirstName(),
//				employeeDto.getLastName(),
//				employeeDto.getEmail()
//				);
//		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
//		Employee employee = modelMapper.map(employeeDto, Employee.class);

		//	Employee savedEmployee = employeeRepository.save(employee);
		
		Employee savedEmployee = AutoEmployeeMapper.mapper.mapToEmployee(employeeDto);
		
		//convert JPA Entity to Dto
		
//		EmployeeDto  savedEmployeeDto = new EmployeeDto(
//				savedEmployee.getId(),
//				savedEmployee.getFirstName(),
//				savedEmployee.getLastName(),
//				savedEmployee.getEmail()
//				);
		
//		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
//		EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
		
		EmployeeDto savedEmployeeDto = AutoEmployeeMapper.mapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
		//convert JPA Entity to Dto
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getEmail()
//				);
//		return employeeDto;
		
//		return EmployeeMapper.mapToEmployeeDto(employee);
		
//		return modelMapper.map(employee, EmployeeDto.class);
		
		return AutoEmployeeMapper.mapper.mapToEmployeeDto(employee);
	}

}
