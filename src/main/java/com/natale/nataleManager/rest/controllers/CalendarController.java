package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Calendar;
import com.natale.nataleManager.service.CalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/calendars")
@Api(tags = {"calendars"})
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Obtains a Calendar by id.")
    public Calendar get(@PathVariable("id") Long id) {
        return calendarService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{courseId}")
    @ApiOperation(value = "Obtains a list of calendars by course.")
    public List<Calendar> getAllByCourse(@PathVariable("courseId") Long courseId) {
        return calendarService.getAllByCourseId(courseId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains a list of all calendars.")
    public List<Calendar> getAll() {
        return calendarService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates a new calendar schedule.")
    public Calendar insert(@RequestBody Calendar calendar) {
        return calendarService.insert(calendar);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Updates a calendar.")
    public Calendar update(@RequestBody Calendar calendar) {
        return calendarService.update(calendar);
    }

}
