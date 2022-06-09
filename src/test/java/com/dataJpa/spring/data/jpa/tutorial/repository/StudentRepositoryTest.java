package com.dataJpa.spring.data.jpa.tutorial.repository;

import com.dataJpa.spring.data.jpa.tutorial.entity.Guardian;
import com.dataJpa.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student  student = Student.builder()
                .emailId("rahul@123")
                .firstName("Rahul")
                .lastName("Mhatre")
                //.guardianName("xyz")
                //.guardainEmail("guardian@mail.com")
                //.guardainMobile("999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("xyz@gmail.com")
                .mobile("99999999")
                .build();

        Student student = Student.builder()
                .firstName("rahul")
                .lastName("mhatre")
                .emailId("rahul@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
}