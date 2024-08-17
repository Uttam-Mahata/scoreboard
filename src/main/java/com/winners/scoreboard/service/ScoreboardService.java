package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Scoreboard;
import com.winners.scoreboard.repository.ExamRepository;
import com.winners.scoreboard.repository.ScoreboardRepository;
import com.winners.scoreboard.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Scoreboard> getScoreboardByExam(Long examId) {
        Optional<Exam> examOpt = examRepository.findById(examId);
        if (examOpt.isPresent()) {
            return scoreboardRepository.findByExam(examOpt.get());
        } else {
            System.out.println("Exam with ID " + examId + " does not exist.");
            throw new IllegalArgumentException("Exam not found");
        }
    }

    public Scoreboard saveScoreboard(Scoreboard scoreboard) {
        return scoreboardRepository.save(scoreboard);
    }

    public Scoreboard updateScoreboard(Long id, Scoreboard scoreboardDetails) {
        Optional<Scoreboard> scoreboardOpt = scoreboardRepository.findById(id);
        if (scoreboardOpt.isPresent()) {
            Scoreboard scoreboard = scoreboardOpt.get();
            scoreboard.setObtainedMarks(scoreboardDetails.getObtainedMarks());
            return scoreboardRepository.save(scoreboard);
        } else {
            System.out.println("Scoreboard entry with ID " + id + " does not exist.");
            throw new IllegalArgumentException("Scoreboard entry not found");
        }
    }

    public void deleteScoreboard(Long id) {
        Optional<Scoreboard> scoreboardOpt = scoreboardRepository.findById(id);
        if (scoreboardOpt.isPresent()) {
            scoreboardRepository.delete(scoreboardOpt.get());
        } else {
            System.out.println("Scoreboard entry with ID " + id + " does not exist.");
            throw new IllegalArgumentException("Scoreboard entry not found");
        }
    }

    public Map<String, Double> getExamStatistics(Long examId) {
        Optional<Exam> examOpt = examRepository.findById(examId);
        if (examOpt.isPresent()) {
            List<Scoreboard> scores = scoreboardRepository.findByExam(examOpt.get());

            double maxMarks = scores.stream().mapToInt(Scoreboard::getObtainedMarks).max().orElse(0);
            double minMarks = scores.stream().mapToInt(Scoreboard::getObtainedMarks).min().orElse(0);
            double avgMarks = scores.stream().mapToInt(Scoreboard::getObtainedMarks).average().orElse(0.0);

            Map<String, Double> stats = new HashMap<>();
            stats.put("maxMarks", maxMarks);
            stats.put("minMarks", minMarks);
            stats.put("avgMarks", avgMarks);

            return stats;
        } else {
            System.out.println("Exam with ID " + examId + " does not exist.");
            throw new IllegalArgumentException("Exam not found");
        }
    }
}
