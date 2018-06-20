package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.Actividad;
import com.natale.nataleManager.service.ActividadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/actividad")
@Api(tags = {"actividad"})
public class ActividadController {

    private final ActividadService actividadService;

    @Autowired
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una Actividad.")
    public Actividad get(@RequestParam("id") Long id) throws Exception {
        return actividadService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos las Actividades.")
    public List<Actividad> getAll() throws Exception {
        return actividadService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nueva Actividad")
    public Actividad insert(@RequestBody Actividad act) throws Exception {
        return actividadService.insert(act);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza una Actividad")
    public Actividad update(@RequestBody Actividad act) throws Exception {
        return actividadService.update(act);
    }

}
