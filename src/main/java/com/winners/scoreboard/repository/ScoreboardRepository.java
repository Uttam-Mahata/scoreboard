package com.winners.scoreboard.repository;

import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// ScoreboardRepository.java
public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {
    List<Scoreboard> findByExam(Exam exam);
}

