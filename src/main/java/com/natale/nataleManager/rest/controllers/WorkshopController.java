package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Workshop;
import com.natale.nataleManager.service.WorkshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/taller")
@Api(tags = {"taller"})
public class WorkshopController {

    private final WorkshopService workshopService;

    @Autowired
    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Workshop.")
    public Workshop get(@RequestParam("id") Long id) {
        return workshopService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los Talleres.")
    public List<Workshop> getAll() {
        return workshopService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Workshop")
    public Workshop insert(@RequestBody Workshop workshop) {
        return workshopService.insert(workshop);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Workshop")
    public Workshop update(@RequestBody Workshop workshop) {
        return workshopService.update(workshop);
    }

}
