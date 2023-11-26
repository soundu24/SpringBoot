package com.capg.employeeservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.employeeservice.dto.DepartmentDto;


@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("api/department/{departmentCode}")
	DepartmentDto getDepartment(@PathVariable String departmentCode);
	
}
