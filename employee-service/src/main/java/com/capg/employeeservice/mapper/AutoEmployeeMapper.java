package com.capg.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {

	AutoEmployeeMapper mapper = Mappers.getMapper(AutoEmployeeMapper.class);
	
	EmployeeDto mapToEmployeeDto(Employee employee);
	
	Employee mapToEmployee(EmployeeDto employeeDto);
}
