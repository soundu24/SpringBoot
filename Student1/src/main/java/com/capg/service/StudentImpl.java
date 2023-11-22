package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Student;
import com.capg.repository.StudentRepo;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepository;
	
	@Override
	public Student addstudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public List<Student> allstudent() {
		List<Student> allstudents = studentRepository.findAll();
		return allstudents;
	}

	
}
