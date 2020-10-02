package com.example.springsecurityexampleservice.controller;

import com.example.springsecurityexampleservice.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
  private static final List<Student> STUDENTS = Arrays.asList(
          new Student(1, "Anna Marie"),
          new Student(2, "Linda Parker"),
          new Student(3, "Tom Riddle"));

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
  public List<Student> getAllStudents() {
    return STUDENTS;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
  public void addNewStudent(@RequestBody Student student) {
    System.out.println("Add Student >>>>");
    System.out.println(student);
    System.out.println("<<<<");
  }

  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteStudent(@PathVariable Integer studentId) {
    System.out.println("Delete Student >>>>");
    System.out.println(studentId);
    System.out.println("<<<<");
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
    System.out.println("Update Student >>>>");
    System.out.println(studentId);
    System.out.println("<<<<");
  }
}
