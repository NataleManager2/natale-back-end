package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Inscription;
import com.natale.nataleManager.model.enums.InscriptionState;
import com.natale.nataleManager.service.InscriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inscripcion")
@Api(tags = {"inscripciones"})
public class InscripcionController {

    private final InscriptionService inscriptionService;

    @Autowired
    public InscripcionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un inscripcion.")
    public Inscription get(@RequestParam("id") Long id) {
        return inscriptionService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos las inscripciones.")
    public List<Inscription> getAll() {
        return inscriptionService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado/pendientes")
    @ApiOperation(value = "Obtiene un listado de todos las inscripciones pendientes o no, segun se exprese en el parametro.")
    public List<Inscription> getInscripcionesPendientes(@RequestParam("pendientes") String estado) {
        return inscriptionService.getInscripcionesByEstado(InscriptionState.valueOf(estado));
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea una nueva inscription")
    public Inscription insert(@RequestBody Inscription inscription) {
        return inscriptionService.insert(inscription);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un inscription")
    public Inscription update(@RequestBody Inscription inscription) {
        return inscriptionService.update(inscription);
    }

}
