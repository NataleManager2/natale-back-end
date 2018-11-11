package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Course;
import com.natale.nataleManager.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/curso")
@Api(tags = {"curso"})
public class CursoController {

    private final CourseService courseService;

    @Autowired
    public CursoController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Course.")
    public Course get(@RequestParam("id") Long id) {
        return courseService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los cursos.")
    public Iterable<Course> getAll() {
        return courseService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Course")
    public Course insert(@RequestBody Course course) {
        return courseService.insert(course);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Course")
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

}
