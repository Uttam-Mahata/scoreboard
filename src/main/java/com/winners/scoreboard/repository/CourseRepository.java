package com.winners.scoreboard.repository;

import com.winners.scoreboard.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

// CourseRepository.java
public interface CourseRepository extends JpaRepository<Course, Long> {
}

