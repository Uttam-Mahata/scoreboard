package com.winners.scoreboard.repository;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// SubjectRepository.java
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByCourse(Course course);
}

