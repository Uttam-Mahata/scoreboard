package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/course/{courseId}")
    public List<Subject> getSubjectsByCourse(@PathVariable Long courseId) {
        return subjectService.getSubjectsByCourse(courseId);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable Long subjectId, @RequestBody Subject subjectDetails) {
        return subjectService.updateSubject(subjectId, subjectDetails);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}

