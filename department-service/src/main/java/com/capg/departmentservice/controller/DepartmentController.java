package com.capg.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	
	//build save department REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
	}
	
	//build get department REST API
	@GetMapping("{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
}
