package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.model.Student;

@SpringBootTest
public class StudentTest {

	private Student student;
	 
	@BeforeAll
	public void setUp() {
		student = new Student();
	}
 
	@Test
	public void testDefaultConstructor() {
		assertEquals(null, student.getName());
		assertEquals(0, student.getAge());
		assertEquals(0.0, student.getSalary(), 0.001);
	}
}
