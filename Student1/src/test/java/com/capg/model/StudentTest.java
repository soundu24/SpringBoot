package com.capg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

	private Student student;
	 
	@Before
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
