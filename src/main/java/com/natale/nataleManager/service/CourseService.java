package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Course get(Long id);
    Course insert(Course course);
    List<Course> getAll();
    Course update(Course course);
    void delete(Course course);
}
