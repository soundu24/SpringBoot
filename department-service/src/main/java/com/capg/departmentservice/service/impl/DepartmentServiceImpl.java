package com.capg.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.entity.Department;
import com.capg.departmentservice.mapper.AutoDepartmentMapper;
import com.capg.departmentservice.mapper.DepartmentMapper;
import com.capg.departmentservice.repository.DepartmentRepository;
import com.capg.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
//		Convert department dto to department JPA Entity
//		Department department = new Department(
//				departmentDto.getId(),
//				departmentDto.getDepartmentName(),
//				departmentDto.getDepartmentDescription(),
//				departmentDto.getDepartmentCode()
//				);
//		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		
//		Department department = modelMapper.map(departmentDto, Department.class);
		
		Department department = AutoDepartmentMapper.mapper.mapToDepartment(departmentDto);
		
		Department savedDepartment = departmentRepository.save(department);
		
		
//		DepartmentDto savedDepartmentDto = new DepartmentDto(
//				savedDepartment.getId(),
//				savedDepartment.getDepartmentName(),
//				savedDepartment.getDepartmentDescription(),
//				savedDepartment.getDepartmentCode()
//				);

//		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
		
//		DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
		
		DepartmentDto savedDepartmentDto = AutoDepartmentMapper.mapper.mapToDepartmentDto(savedDepartment);
		
		return savedDepartmentDto;
		
	}


	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);

//		Convert JPA Entity to department Dto
//		DepartmentDto departmentDto = new DepartmentDto(
//				department.getId(),
//				department.getDepartmentName(),
//				department.getDepartmentDescription(),
//				department.getDepartmentCode()
//				);
//		return departmentDto;
		
//		return DepartmentMapper.mapToDepartmentDto(department);
		
//		return modelMapper.map(department, DepartmentDto.class);
		
		return AutoDepartmentMapper.mapper.mapToDepartmentDto(department);
	}
}
