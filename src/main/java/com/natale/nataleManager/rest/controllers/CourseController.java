package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Course;
import com.natale.nataleManager.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/courses")
@Api(tags = {"courses"})
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Obtains a Course.")
    public Course get(@PathVariable("id") Long id) {
        return courseService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains a list of all courses.")
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates a new Course")
    public Course insert(@RequestBody Course course) {
        return courseService.insert(course);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Updates a Course")
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

}
