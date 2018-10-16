package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.Inscripcion;
import com.natale.nataleManager.model.enums.EstadoInscripcion;
import com.natale.nataleManager.service.InscripcionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inscripcion")
@Api(tags = {"inscripciones"})
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @Autowired
    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un inscripcion.")
    public Inscripcion get(@RequestParam("id") Long id) {
        return inscripcionService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos las inscripciones.")
    public List<Inscripcion> getAll() {
        return inscripcionService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado/pendientes")
    @ApiOperation(value = "Obtiene un listado de todos las inscripciones pendientes o no, segun se exprese en el parametro.")
    public List<Inscripcion> getInscripcionesPendientes(@RequestParam("pendientes") String estado) {
        return inscripcionService.getInscripcionesByEstado(EstadoInscripcion.valueOf(estado));
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nueva inscripcion")
    public Inscripcion insert(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.insert(inscripcion);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un inscripcion")
    public Inscripcion update(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.update(inscripcion);
    }

}
