
package com.winners.scoreboard.service;

import com.winners.scoreboard.entity.Course;
import com.winners.scoreboard.entity.Subject;
import com.winners.scoreboard.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CourseService courseService;

    public List<Subject> getSubjectsByCourse(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return subjectRepository.findByCourse(course);
    }

//    public Subject createSubject(Subject subject) {
//        return subjectRepository.save(subject);
//    }

    public Subject createSubject(Subject subject) {
        // Ensure the course is properly set before saving
        Course course = courseService.getCourseById(subject.getCourse().getCourseId());
        subject.setCourse(course);
        return subjectRepository.save(subject);
    }


    public Subject updateSubject(Long subjectId, Subject subjectDetails) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + subjectId));

        subject.setSubjectName(subjectDetails.getSubjectName());
        subject.setCourse(subjectDetails.getCourse());

        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + subjectId));

        subjectRepository.delete(subject);
    }
}
