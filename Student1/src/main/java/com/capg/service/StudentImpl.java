package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Student;
import com.capg.repository.StudentRepo;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	StudentRepo repo;
 
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		repo.findAll().forEach(student1 -> students.add(student1));
		return students;
	}
 
	@Override
	public void update(Student student) {
		Student s = new Student();
		s.setName(student.getName());
		s.setAge(student.getAge());
		s.setSalary(student.getSalary());
		repo.save(student);
	}
 
	@Override
	public void delete(String name) {
		repo.deleteByName(name);
 
	}
 
	@Override
	public Student save(Student student) {
		return repo.save(student);
	}

	
}
