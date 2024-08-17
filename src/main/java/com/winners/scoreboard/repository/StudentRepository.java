package com.winners.scoreboard.repository;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// StudentRepository.java
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(Course course);
}

