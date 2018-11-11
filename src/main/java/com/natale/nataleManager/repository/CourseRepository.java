package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Course;
import com.natale.nataleManager.model.enums.ActivityState;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    List<Course> findAllByState(ActivityState activityState);
    List<Course> findAll();
}
