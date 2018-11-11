package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Course;
import com.natale.nataleManager.repository.CourseRepository;
import com.natale.nataleManager.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseServiceImpl implements CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course get(Long id)  {
        Optional<Course> curso = Optional.of(new Course());
        try{
            curso = courseRepository.findById(id);
            log.debug("findOne curso id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne curso with id: "+id);
        }
        return curso.orElse(null);
    }

    @Override
    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Iterable<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course update(Course course) {
        try {
            if (course.getNullAtributes().size() == 0) {
                return courseRepository.save(course);
            }
        } catch (IllegalAccessException e) {
            log.error("El course no se actualizo porque tenia atributos nulos: "+e);
        }

        return course;
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }


}
