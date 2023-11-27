package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.model.Student;
import com.capg.repository.StudentRepo;

//@DataMongoTest
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void testSaveAndFindByName() {

        Student student = new Student(25, "John", 50000);

        Student savedStudent = studentRepo.save(student);

        Student foundStudent = studentRepo.findByName("John");

        assertNotNull(foundStudent);
        assertEquals(savedStudent.getName(), foundStudent.getName());
        assertEquals(savedStudent.getAge(), foundStudent.getAge());
        assertEquals(savedStudent.getSalary(), foundStudent.getSalary(), 0.01);
    }
}
