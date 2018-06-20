package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.TipoActividad;
import com.natale.nataleManager.service.TipoActividadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/actividad/tipo")
@Api(tags = {"tipo-actividad"})
public class TipoActividadController {

    private final TipoActividadService tipoActividadService;

    @Autowired
    public TipoActividadController(TipoActividadService tipoActividadService) {
        this.tipoActividadService = tipoActividadService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una tipo de actividad.")
    public TipoActividad get(@RequestParam("id") Long id) throws Exception {
        return tipoActividadService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los tipos de actividad.")
    public List<TipoActividad> getAll() throws Exception {
        return tipoActividadService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nuevo tipo de actividad.")
    public TipoActividad insert(@RequestBody TipoActividad act) throws Exception {
        return tipoActividadService.insert(act);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un tipo de actividad")
    public TipoActividad update(@RequestBody TipoActividad act) throws Exception {
        return tipoActividadService.update(act);
    }

}
