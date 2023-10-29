package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email, String name){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("There is no record with Student ID:"+ studentId));
        if(!(email ==null || email.isEmpty()) && !Objects.equals(student.getEmail(),email)){
            if(studentRepository.findStudentByEmail(email).isPresent()){
                throw new IllegalStateException("This email already exists in the DB");
            }
            student.setEmail(email);
        }
        if(!(name ==null || name.isEmpty()) && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        studentRepository.save(student);
    }
}
