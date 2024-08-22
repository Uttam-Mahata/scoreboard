package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.repository.CourseRepository;
import com.winners.scoreboard.repository.ExamRepository;
import com.winners.scoreboard.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

//    Get Courses
    public List<Course> getExamAllCourses() {
        return courseRepository.findAll();
    }

//    Get Subject by Course
    public List<Subject> getExamSubjectByCourse(Course course) {
        return subjectRepository.findByCourse(course);
    }

//    Get Exams by Subject
    public List<Exam> getExamsBySubject(Subject subject) {
        return examRepository.findBySubject(subject);
    }

//    Get Exam by Id
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new IllegalArgumentException("Exam not found with id " + examId));
    }

// Create Exam on SubjectId
    public Exam createExam(Long subjectId, Exam exam) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + subjectId));

        exam.setSubject(subject);
        return examRepository.save(exam);
    }

//    Update Exam

    public Exam updateExam(Long examId, Exam examDetails) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new IllegalArgumentException("Exam not found with id " + examId));

        exam.setExamName(examDetails.getExamName());
        exam.setExamDate(examDetails.getExamDate());
        exam.setFullMarks(examDetails.getFullMarks());
        exam.setSubject(examDetails.getSubject());

        return examRepository.save(exam);
    }

//    Delete Exam
    public void deleteExam(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new IllegalArgumentException("Exam not found with id " + examId));

        examRepository.delete(exam);
    }




}
