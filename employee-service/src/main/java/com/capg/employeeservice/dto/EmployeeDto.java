package com.capg.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "EmployeeDto model information"
		)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;

	@Schema(
			description = "First Name"
			)
	private String firstName;
	@Schema(
			description = "Last Name"
			)
	private String lastName;
	@Schema(
			description = "Email"
			)
	private String email;
	@Schema(
			description = "Department Code"
			)
	private String departmentCode;
	@Schema(
			description = "Organization Code"
			)
	private String organizationCode;
}
