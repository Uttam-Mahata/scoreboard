package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;

import java.util.List;

public interface ExamService {
    List<Course> getAllCourses();
    List<Subject> getSubjectsByCourse(Course course);
    List<Exam> getExamsBySubject(Subject subject);
    Exam saveExam(Exam exam);
    void deleteExam(Long examId);
    Exam getExamById(Long examId);
}
