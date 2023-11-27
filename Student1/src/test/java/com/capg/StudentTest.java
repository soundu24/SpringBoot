package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.model.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capg.model.Student;

public class StudentTest {

    @Test
    public void testStudentGetterAndSetter() {
        // Create a student
        Student student = new Student();
        student.setName("John");
        student.setAge(25);
        student.setSalary(50000);

        // Verify the values using getters
        assertEquals("John", student.getName());
        assertEquals(25, student.getAge());
        assertEquals(50000, student.getSalary(), 0.01); // Using delta for double comparison
    }

    @Test
    public void testStudentConstructor() {
        // Create a student using the constructor
        Student student = new Student(25, "John", 50000);

        // Verify the values using getters
        assertEquals("John", student.getName());
        assertEquals(25, student.getAge());
        assertEquals(50000, student.getSalary(), 0.01); // Using delta for double comparison
    }
}
