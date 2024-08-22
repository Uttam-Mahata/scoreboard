package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = examService.getExamAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/subjects")

    public ResponseEntity<List<Subject>> getSubjectsByCourse(@RequestParam Long courseId) {
        Course course = new Course(); // Assuming you have a method to fetch course by ID
        course.setCourseId(courseId);
        List<Subject> subjects = examService.getExamSubjectByCourse(course);
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/exams")
    public ResponseEntity<List<Exam>> getExamsBySubject(@RequestParam Long subjectId) {
        Subject subject = new Subject(); // Assuming you have a method to fetch subject by ID
        subject.setSubjectId(subjectId);
        List<Exam> exams = examService.getExamsBySubject(subject);
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return ResponseEntity.ok(exam);
    }

    @PostMapping("/{subjectId}")
    public ResponseEntity<Exam> createExam(@PathVariable Long subjectId, @RequestBody Exam exam) {
        Exam createdExam = examService.createExam(subjectId, exam);
        return ResponseEntity.ok(createdExam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        Exam updatedExam = examService.updateExam(id, examDetails);
        return ResponseEntity.ok(updatedExam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}
