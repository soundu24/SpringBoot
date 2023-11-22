package com.capg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

	@Id
	private String studentId;
	private String studentName;
	private double salary;
	private int age;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentId, String studentName, double salary, int age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.salary = salary;
		this.age = age;
	}



	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
