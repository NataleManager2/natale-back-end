package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Activity;
import com.natale.nataleManager.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/actividad")
@Api(tags = {"actividad"})
public class ActividadController {

    private final ActivityService activityService;

    @Autowired
    public ActividadController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una Activity.")
    public Activity get(@RequestParam("id") Long id) {
        return activityService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos las Actividades.")
    public List<Activity> getAll() {
        return activityService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nueva Activity")
    public Activity insert(@RequestBody Activity act) {
        return activityService.insert(act);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza una Activity")
    public Activity update(@RequestBody Activity act) {
        return activityService.update(act);
    }

}
