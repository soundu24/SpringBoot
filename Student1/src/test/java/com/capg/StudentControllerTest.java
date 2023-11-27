package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import com.capg.controller.StudentController;
import com.capg.model.Student;
import com.capg.service.StudentImpl;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    private static final Logger log = LoggerFactory.getLogger(StudentControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentImpl studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void getAllStudentsTest() throws Exception {
        // Mocking service response
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, "John", 50000));
        students.add(new Student(22, "Alice", 60000));

        when(studentService.getAllStudents()).thenReturn(students);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/allStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(students.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Alice"));

        log.info("Get All Students Test Passed");
    }

//    @Test
//    public void updateStudentTest() throws Exception {
//        Student updatedStudent = new Student(25, "John", 60000);
//       when(studentService.update(any(Student.class))).thenReturn(updatedStudent);
//
//      
//        mockMvc.perform(MockMvcRequestBuilders.put("/students/{name}", "John")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"age\": 25, \"name\": \"John\", \"salary\": 60000}")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(60000));
//
//        log.info("Update Student Test Passed");
//    }

    @Test
    public void deleteStudentTest() throws Exception {
        // Mocking service response
        doNothing().when(studentService).delete("Alice");

        // Perform DELETE request for deleting a student
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{name}", "Alice"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted!-"));

        log.info("Delete Student Test Passed");
    }

    @Test
    public void addStudentTest() throws Exception {
      
        Student newStudent = new Student(28, "Bob", 70000);
        when(studentService.save(any(Student.class))).thenReturn(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"age\": 28, \"name\": \"Bob\", \"salary\": 70000}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bob"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(70000));

        log.info("Add Student Test Passed");
    }
}
