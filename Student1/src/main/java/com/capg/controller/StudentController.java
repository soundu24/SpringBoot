package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Student;
import com.capg.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student){
		return studentService.addstudent(student);
	}
	@GetMapping("/allstudent")
	public List<Student> allstudents(){
		return studentService.allstudent();
	}
	
}
