package com.winners.scoreboard.entity;

import jakarta.persistence.*;
// Scoreboard.java
@Entity
@Table(name = "Scoreboard")
public class Scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreboardId;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private int obtainedMarks;

    // Getters and Setters

    public Long getScoreboardId() {
        return scoreboardId;
    }

    public void setScoreboardId(Long scoreboardId) {
        this.scoreboardId = scoreboardId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
}

