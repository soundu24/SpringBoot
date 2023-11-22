package com.capg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.model.Student;

@Service
public interface StudentService {

	public Student addstudent(Student student);

	public List<Student> allstudent();
	
}
