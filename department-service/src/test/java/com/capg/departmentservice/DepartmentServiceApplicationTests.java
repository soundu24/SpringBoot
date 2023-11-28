package com.capg.departmentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.departmentservice.dto.DepartmentDto;
import com.capg.departmentservice.service.DepartmentService;
 
@SpringBootTest
class DepartmentServiceApplicationTests {
 
		@Autowired
		private DepartmentService departmentService;
		@Test
		void contextLoads() {

			DepartmentDto inputDto = new DepartmentDto();
			inputDto.setDepartmentName("IT");
			inputDto.setDepartmentDescription("IT INFO");
			inputDto.setDepartmentCode("IT001");
		DepartmentDto saveDto = departmentService.saveDepartment(inputDto);

			assertEquals(inputDto.getDepartmentName(), saveDto.getDepartmentName());
			assertEquals(inputDto.getDepartmentDescription(), saveDto.getDepartmentDescription());
			assertEquals(inputDto.getDepartmentCode(), saveDto.getDepartmentCode());
		}
 
}