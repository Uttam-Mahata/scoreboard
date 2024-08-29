package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.*;
import com.winners.scoreboard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageScoreboardService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Subject> getSubjectsByCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(subjectRepository::findByCourse).orElse(null);
    }

    public List<Exam> getExamsBySubject(Long subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        return subject.map(examRepository::findBySubject).orElse(null);
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(studentRepository::findByCourse).orElse(null);
    }

    public List<Scoreboard> getScoresByExam(Long examId) {
        Optional<Exam> exam = examRepository.findById(examId);
        return exam.map(scoreboardRepository::findByExam).orElse(null);
    }

    public Scoreboard addScore(Long examId, Long studentId, int obtainedMarks) {
        Optional<Exam> exam = examRepository.findById(examId);
        Optional<Student> student = studentRepository.findById(studentId);

        if (exam.isPresent() && student.isPresent()) {
            Scoreboard scoreboard = new Scoreboard();
            scoreboard.setExam(exam.get());
            scoreboard.setStudent(student.get());
            scoreboard.setObtainedMarks(obtainedMarks);
            return scoreboardRepository.save(scoreboard);
        } else {
            return null; // Handle error case
        }
    }

    public Scoreboard updateScore(Long scoreboardId, int obtainedMarks) {
        Optional<Scoreboard> scoreboardOpt = scoreboardRepository.findById(scoreboardId);
        if (scoreboardOpt.isPresent()) {
            Scoreboard scoreboard = scoreboardOpt.get();
            scoreboard.setObtainedMarks(obtainedMarks);
            return scoreboardRepository.save(scoreboard);
        } else {
            return null; // Handle error case
        }
    }

    public void deleteScore(Long scoreboardId) {
        scoreboardRepository.deleteById(scoreboardId);
    }
}
