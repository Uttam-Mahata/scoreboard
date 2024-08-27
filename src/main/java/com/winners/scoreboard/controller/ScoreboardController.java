package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.*;
import com.winners.scoreboard.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scoreboard")

public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return scoreboardService.getAllCourses();
    }

    @GetMapping("/subjects/{courseId}")
    public List<Subject> getSubjectsByCourse(@PathVariable Long courseId) {
        return scoreboardService.getSubjectsByCourse(courseId);
    }

    @GetMapping("/exams/{subjectId}")
    public List<Exam> getExamsBySubject(@PathVariable Long subjectId) {
        return scoreboardService.getExamsBySubject(subjectId);
    }

    @GetMapping("/students/{courseId}")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return scoreboardService.getStudentsByCourse(courseId);
    }

    @PostMapping("/add-score")
    public Scoreboard addScore(@RequestParam Long examId,
                               @RequestParam Long studentId,
                               @RequestParam int obtainedMarks) {
        return scoreboardService.addScore(examId, studentId, obtainedMarks);
    }
}
