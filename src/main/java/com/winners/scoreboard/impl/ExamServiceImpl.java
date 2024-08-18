package com.winners.scoreboard.impl;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.repository.CourseRepository;
import com.winners.scoreboard.repository.ExamRepository;
import com.winners.scoreboard.repository.SubjectRepository;
import com.winners.scoreboard.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectsByCourse(Course course) {
        return subjectRepository.findByCourse(course);
    }

    @Override
    public List<Exam> getExamsBySubject(Subject subject) {
        return examRepository.findBySubject(subject);
    }

    @Override
    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }

    @Override
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId).orElse(null);
    }
}
