package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.model.Student;
import com.capg.repository.StudentRepo;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	StudentRepo repo;
	
	@Test
	public void addStudent() {
		Student s = new Student(23,"Soundu",12324);
		repo.save(s);
		List<Student> s1 = repo.findAll();
		assertEquals(1, s1.size());
	}
}
