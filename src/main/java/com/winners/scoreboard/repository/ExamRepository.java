package com.winners.scoreboard.repository;

import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findBySubject(Subject subject);
}
