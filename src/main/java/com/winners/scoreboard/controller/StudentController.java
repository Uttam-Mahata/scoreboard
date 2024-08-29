package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.Student;
import com.winners.scoreboard.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/course/{courseId}")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return studentService.getStudentsByCourse(courseId);
    }

    @PostMapping("/course/{courseId}")
    public Student createStudent(@PathVariable Long courseId, @RequestBody Student student) {
        return studentService.createStudent(courseId, student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student studentDetails) {
        return studentService.updateStudent(studentId, studentDetails);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
