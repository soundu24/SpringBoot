package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
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
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, "Kavya", 50000));
        students.add(new Student(22, "Pushpa", 60000));

        when(studentRepo.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertEquals(students.size(), result.size());
    }

    @Test
    public void testUpdate() {
        Student studentToUpdate = new Student(23, "Kavya", 50000);
        when(studentRepo.save(studentToUpdate)).thenReturn(studentToUpdate);
        studentService.update(studentToUpdate);

        // Verify that the save method in the repository was called
    }

    @Test
    public void testDelete() {
    	Student studentNameToDelete = new Student(23, "Kavya", 50000);
    	String name = "Kavya";
    	studentRepo.deleteByName(name);
    	verify(studentRepo,times(1)).deleteByName(name);
        
    }

    @Test
    public void testSave() {
        // Mocking repository response
        Student studentToSave = new Student(28, "Bob", 70000);
        when(studentRepo.save(studentToSave)).thenReturn(studentToSave);

        Student result = studentService.save(studentToSave);

        assertEquals(studentToSave, result);
    }

}

