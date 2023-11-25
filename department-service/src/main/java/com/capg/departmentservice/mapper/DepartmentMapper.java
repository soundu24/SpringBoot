package com.capg.departmentservice.mapper;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.entity.Department;

public class DepartmentMapper {

	//convert User JPA entity into UserDto
		public static DepartmentDto mapToDepartmentDto(Department department) {
			DepartmentDto departmentDto = new DepartmentDto(
					department.getId(),
					department.getDepartmentName(),
					department.getDepartmentDescription(),
					department.getDepartmentCode()
					);
			return departmentDto;
		}
		
		//convert Dto to JPA Entity
		public static Department mapToDepartment(DepartmentDto departmentDto) {
			Department department = new Department(
					departmentDto.getId(),
					departmentDto.getDepartmentName(),
					departmentDto.getDepartmentDescription(),
					departmentDto.getDepartmentCode()
					);
			return department;
		}
}
