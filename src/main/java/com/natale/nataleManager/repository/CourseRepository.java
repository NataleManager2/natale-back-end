package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Course;
import com.natale.nataleManager.model.enums.ActivityState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAllByState(ActivityState activityState);
}
