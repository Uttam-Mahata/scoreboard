package com.winners.scoreboard.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "exam_name", nullable = false)
    private String examName;

    @Column(name = "exam_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date examDate;

    @Column(name = "full_marks", nullable = false)
    private Integer fullMarks;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Constructors, Getters, and Setters


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

    public Integer getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Integer fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
