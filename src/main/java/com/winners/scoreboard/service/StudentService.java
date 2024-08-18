package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Student;
import com.winners.scoreboard.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    public List<Student> getStudentsByCourse(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return studentRepository.findByCourse(course);
    }

    public Student createStudent(Long courseId, Student student) {
        Course course = courseService.getCourseById(courseId);
        student.setCourse(course);

        return studentRepository.save(student);
    }

    public Student updateStudent(Long studentId, Student studentDetails) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + studentId));

        student.setStudentName(studentDetails.getStudentName());
        student.setCourse(studentDetails.getCourse());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + studentId));

        studentRepository.delete(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + studentId));
    }


}
