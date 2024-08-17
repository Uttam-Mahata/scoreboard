package com.winners.scoreboard.controller;

import com.winners.scoreboard.entity.Scoreboard;
import com.winners.scoreboard.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// ScoreboardController.java
@RestController
@RequestMapping("/api/scoreboards")
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

//    Load Courses


    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Scoreboard>> getScoreboardByExam(@PathVariable Long examId) {
        List<Scoreboard> scoreboard = scoreboardService.getScoreboardByExam(examId);
        return ResponseEntity.ok(scoreboard);
    }

    @PostMapping
    public ResponseEntity<Scoreboard> createScoreboard(@RequestBody Scoreboard scoreboard) {
        Scoreboard createdScoreboard = scoreboardService.saveScoreboard(scoreboard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdScoreboard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scoreboard> updateScoreboard(@PathVariable Long id, @RequestBody Scoreboard scoreboardDetails) {
        Scoreboard updatedScoreboard = scoreboardService.updateScoreboard(id, scoreboardDetails);
        return ResponseEntity.ok(updatedScoreboard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScoreboard(@PathVariable Long id) {
        scoreboardService.deleteScoreboard(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exam/{examId}/stats")
    public ResponseEntity<Map<String, Double>> getExamStatistics(@PathVariable Long examId) {
        Map<String, Double> stats = scoreboardService.getExamStatistics(examId);
        return ResponseEntity.ok(stats);
    }
}

