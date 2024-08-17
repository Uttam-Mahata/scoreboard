package com.winners.scoreboard.entity;

import jakarta.persistence.*;

import java.sql.Date;

// Exam.java
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @Column(nullable = false)
    private String examName;

    @Column(nullable = false)
    private Date examDate;

    @Column(nullable = false)
    private int fullMarks;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Getters and Setters


    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(int fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

