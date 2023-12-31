package com.capg.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.capg.employeeservice.dto.APIResponseDto;
import com.capg.employeeservice.dto.DepartmentDto;
import com.capg.employeeservice.dto.EmployeeDto;
import com.capg.employeeservice.dto.OrganizationDto;
import com.capg.employeeservice.entity.Employee;
import com.capg.employeeservice.mapper.AutoEmployeeMapper;
import com.capg.employeeservice.mapper.EmployeeMapper;
import com.capg.employeeservice.repository.EmployeeRepository;
import com.capg.employeeservice.services.APIClient;
import com.capg.employeeservice.services.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;

//	private RestTemplate restTemplate;

	private WebClient webClient;

	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// convert employee dto to JPA entity
//		Employee employee = new Employee(
//				employeeDto.getId(),
//				employeeDto.getFirstName(),
//				employeeDto.getLastName(),
//				employeeDto.getEmail(),
//				employeeDto.getDepartmentCode()
//				);
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

//		Employee employee = modelMapper.map(employeeDto, Employee.class);

		Employee savedEmployee = employeeRepository.save(employee);

//		Employee savedEmployee = AutoEmployeeMapper.mapper.mapToEmployee(employeeDto);

		// convert JPA Entity to Dto
//		
//		EmployeeDto  savedEmployeeDto = new EmployeeDto(
//				savedEmployee.getId(),
//				savedEmployee.getFirstName(),
//				savedEmployee.getLastName(),
//				savedEmployee.getEmail(),
//				savedEmployee.getDepartmentCode()
//				);

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

//		EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);

//		EmployeeDto savedEmployeeDto = AutoEmployeeMapper.mapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

		LOGGER.info("inside getEmployeeByID() method");

		Employee employee = employeeRepository.findById(employeeId).get();

//	ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/"+ employee.getDepartmentCode(), 
//				DepartmentDto.class);
//	
//	DepartmentDto departmentDto = responseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/department/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();
		
		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();

//	DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

		// convert JPA Entity to Dto
//		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
//				employee.getEmail(), employee.getDepartmentCode());

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganization(organizationDto);
		return apiResponseDto;

//		return EmployeeMapper.mapToEmployeeDto(employee);

//		return modelMapper.map(employee, EmployeeDto.class);

//		return AutoEmployeeMapper.mapper.mapToEmployeeDto(employee);
	}

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

		LOGGER.info("inside getDefaultDepartment() method");

		Employee employee = employeeRepository.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD01");
		departmentDto.setDepartmentDescription("Research & Development Department");
		// convert JPA Entity to Dto
//		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
//				employee.getEmail(), employee.getDepartmentCode());

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);

		return apiResponseDto;

	}

}
