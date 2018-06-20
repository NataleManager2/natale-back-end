package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.SubtipoActividad;
import com.natale.nataleManager.service.SubtipoActividadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/actividad/subtipo")
@Api(tags = {"subtipo-actividad"})
public class SubtipoActividadController {

    private final SubtipoActividadService subtipoActividadService;

    @Autowired
    public SubtipoActividadController(SubtipoActividadService subtipoActividadService) {
        this.subtipoActividadService = subtipoActividadService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una subtipo de actividad.")
    public SubtipoActividad get(@RequestParam("id") Long id) throws Exception {
        return subtipoActividadService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los subtipo de actividad.")
    public List<SubtipoActividad> getAll() throws Exception {
        return subtipoActividadService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nuevo subtipo de actividad.")
    public SubtipoActividad insert(@RequestBody SubtipoActividad act) throws Exception {
        return subtipoActividadService.insert(act);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un subtipo de actividad")
    public SubtipoActividad update(@RequestBody SubtipoActividad act) throws Exception {
        return subtipoActividadService.update(act);
    }

}
