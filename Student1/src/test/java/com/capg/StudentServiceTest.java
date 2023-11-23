package com.capg;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capg.model.Student;
import com.capg.repository.StudentRepo;
import com.capg.service.StudentImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@Autowired
	private StudentImpl service;

	@MockBean
	private StudentRepo repository;
	
	@Test
	private void getAllStudentsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Student(23,"happy",78643.0), 
				new Student(23,"xyz",45648.9)).collect(Collectors.toList()));
		assertEquals(2, service.getAllStudents().size());
	}
}
