package com.example.demo.repository;


import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.Month;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@Sql(scripts = "/data.sql")
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void StudentRepository_SaveAll_ReturnSavedStudent(){
        //Arrange
        Student student = Student.builder()
                .name("Shrey")
                .dob(LocalDate.of(2004, Month.JANUARY, 24))
                .email("shshhs@gmail.com").build();
        //Act
        Student savedStudent = studentRepository.save(student);
        //Assert
        Assertions.assertNotNull(savedStudent);
        Assertions.assertEquals(savedStudent.getId(), student.getId());
    }
}
