package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Calendar;
import com.natale.nataleManager.service.CalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/calendario")
@Api(tags = {"calendario"})
public class CalendarioController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarioController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Calendar.")
    public Calendar get(@RequestParam("id") Long id) {
        return calendarService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los calendarios.")
    public List<Calendar> getAllByCurId(Long curId) {
        return calendarService.getAllByCurId(curId);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Calendar")
    public Calendar insert(@RequestBody Calendar calendar) {
        return calendarService.insert(calendar);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Calendar")
    public Calendar update(@RequestBody Calendar calendar) {
        return calendarService.update(calendar);
    }

}
