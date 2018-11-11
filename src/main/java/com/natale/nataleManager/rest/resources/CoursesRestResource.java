package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "courses", itemResourceRel = "course", path = "/api/resource/courses")
public interface CoursesRestResource extends PagingAndSortingRepository<Course, Long> {
    Course findByState(@Param("state") String state);
}
