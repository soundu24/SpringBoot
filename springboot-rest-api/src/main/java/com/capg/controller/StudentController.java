package com.capg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student s = new Student(1, "Soundu","S");
//		return new ResponseEntity<Student>(s, HttpStatus.OK);
	return ResponseEntity.ok().header("customHeader", "Soundu").body(s);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> s = new ArrayList<Student>();
		s.add(new Student(1,"Soundu","S"));
		s.add(new Student(2,"Rakesh","R"));
		s.add(new Student(3,"Samu","s"));
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("/{id}/{firstname}/{lastName}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("firstname") String firstName,
			@PathVariable String lastName) {
			Student s =	new Student(studentId, firstName, lastName);
			return ResponseEntity.ok(s);
	}
	
	@GetMapping("/query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
			@RequestParam String firstName,
			@RequestParam String lastName) {
		Student s= new Student(id,firstName,lastName);
		return ResponseEntity.ok(s);
	}
	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student>  createStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getFirstName());
		System.out.println(s.getLastName());
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<Student>  updateStudent(@PathVariable int id, 
			@RequestBody Student s) {
		System.out.println(s.getFirstName());
		System.out.println(s.getLastName());
		return ResponseEntity.ok(s);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String>  deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return ResponseEntity.ok("Student deleted successfully!");
	}
	
}
