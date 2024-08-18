package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.repository.SubjectRepository;
import com.winners.scoreboard.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {

    @Autowired
    private ExamService examService;

    private SubjectRepository subjectRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return examService.getAllCourses();
    }

    @GetMapping("/subjects")
    public List<Subject> getSubjectsByCourse(@RequestParam Long courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
        return examService.getSubjectsByCourse(course);
    }

    @GetMapping("/list")
    public List<Exam> getExamsBySubject(@RequestParam Long subjectId) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        return examService.getExamsBySubject(subject);
    }

    @PostMapping("/add")
    public Exam addExam(@RequestBody Exam exam) {
        if (exam.getSubject() != null && exam.getSubject().getSubjectId() != null) {
            Subject subject = subjectRepository.findById(exam.getSubject().getSubjectId()).orElse(null);
            if (subject != null) {
                exam.setSubject(subject);
            } else {
                throw new RuntimeException("Subject not found");
            }
        }
        return examService.saveExam(exam);
    }


    @PutMapping("/edit/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        Exam exam = examService.getExamById(id);
        if (exam != null) {
            exam.setExamName(examDetails.getExamName());
            exam.setExamDate(examDetails.getExamDate());
            exam.setFullMarks(examDetails.getFullMarks());
            exam.setSubject(examDetails.getSubject());
            return examService.saveExam(exam);
        }
        return null; // or throw an exception
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
