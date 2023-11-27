package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.model.Student;
import com.capg.repository.StudentRepo;
import com.capg.service.StudentImpl;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentImpl studentService;

    @Test
    public void testGetAllStudents() {
        // Mocking repository response
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, "John", 50000));
        students.add(new Student(22, "Alice", 60000));

        when(studentRepo.findAll()).thenReturn(students);

        // Test the service method
        List<Student> result = studentService.getAllStudents();

        // Verify the result
        assertEquals(students.size(), result.size());
    }

    @Test
    public void testUpdate() {
        // Mocking repository response
        Student studentToUpdate = new Student(25, "John", 50000);
        when(studentRepo.save(studentToUpdate)).thenReturn(studentToUpdate);

        // Test the service method
        studentService.update(studentToUpdate);

        // Verify that the save method in the repository was called
    }

//    @Test
//    public void testDelete() {
//        // Mocking repository response
//        String studentNameToDelete = "Alice";
//        when(studentRepo.deleteByName(studentNameToDelete)).thenReturn(Optional.of(new Student()));
//
//        // Test the service method
//        studentService.delete(studentNameToDelete);
//
//        // Verify that the delete method in the repository was called
//    }

    @Test
    public void testSave() {
        // Mocking repository response
        Student studentToSave = new Student(28, "Bob", 70000);
        when(studentRepo.save(studentToSave)).thenReturn(studentToSave);

        // Test the service method
        Student result = studentService.save(studentToSave);

        // Verify the result
        assertEquals(studentToSave, result);
    }

    // Add more tests as needed for other service methods

}

