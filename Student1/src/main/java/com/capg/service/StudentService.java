package com.capg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.model.Student;

@Service
public interface StudentService {

	Student getByName(String name);
	 
	void update(Student student);
 
	List<Student> getAllStudents();
 
	void delete(String name);
 
	Student save(Student student);
 
	
}
