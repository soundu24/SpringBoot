package com.capg.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.entity.Department;
import com.capg.departmentservice.repository.DepartmentRepository;
import com.capg.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
//		Convert department dto to department JPA Entity
		Department department = new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode()
				);
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode()
				);
		
		return savedDepartmentDto;
	}


	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);

//		Convert JPA Entity to department Dto
		DepartmentDto departmentDto = new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode()
				);
		
		return departmentDto;
	}
}
