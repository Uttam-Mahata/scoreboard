package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Exam;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.repository.ExamRepository;
import com.winners.scoreboard.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Exam> getExamsBySubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + subjectId));
        return examRepository.findBySubject(subject);
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(Long examId, Exam examDetails) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new IllegalArgumentException("Exam not found with id " + examId));

        exam.setExamName(examDetails.getExamName());
        exam.setExamDate(examDetails.getExamDate());
        exam.setSubject(examDetails.getSubject());

        return examRepository.save(exam);
    }

    public void deleteExam(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new IllegalArgumentException("Exam not found with id " + examId));

        examRepository.delete(exam);
    }
}

