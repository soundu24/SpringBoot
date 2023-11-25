package com.capg.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.entity.Department;

@Mapper
public interface AutoDepartmentMapper {

	AutoDepartmentMapper mapper = Mappers.getMapper(AutoDepartmentMapper.class);
	
	DepartmentDto mapToDepartmentDto(Department department);
	
	Department mapToDepartment(DepartmentDto departmentDto);
}
