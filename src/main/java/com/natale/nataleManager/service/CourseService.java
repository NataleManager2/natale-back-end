package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Course get(Long id);
    Course insert(Course course);
    Iterable<Course> getAll();
    Course update(Course course);
    void delete(Course course);
}
