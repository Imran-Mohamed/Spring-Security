package com.example.springsecurityexampleservice.controller;

import com.example.springsecurityexampleservice.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Iron Man"),
            new Student(2,"Black Panther"),
            new Student(3,"Thor")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student "+studentId+"does not exist"));
    }
}
