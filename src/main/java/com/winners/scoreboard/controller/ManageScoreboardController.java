package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.*;
import com.winners.scoreboard.service.ManageScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manage-scoreboard")
@CrossOrigin(origins = "http://localhost:4200")
public class ManageScoreboardController {

    @Autowired
    private ManageScoreboardService scoreboardService;

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

    @GetMapping("/scores/{examId}")
    public List<Scoreboard> getScoresByExam(@PathVariable Long examId) {
        return scoreboardService.getScoresByExam(examId);
    }

    @PostMapping("/add-score")
    public Scoreboard addScore(@RequestParam Long examId,
                               @RequestParam Long studentId,
                               @RequestParam int obtainedMarks) {
        return scoreboardService.addScore(examId, studentId, obtainedMarks);
    }

    @PutMapping("/update-score/{scoreboardId}")
    public Scoreboard updateScore(@PathVariable Long scoreboardId,
                                  @RequestParam int obtainedMarks) {
        return scoreboardService.updateScore(scoreboardId, obtainedMarks);
    }

    @DeleteMapping("/delete-score/{scoreboardId}")
    public void deleteScore(@PathVariable Long scoreboardId) {
        scoreboardService.deleteScore(scoreboardId);
    }
}
