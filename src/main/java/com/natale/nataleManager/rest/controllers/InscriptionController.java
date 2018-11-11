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
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Obtains an inscription.")
    public Inscription get(@PathVariable("id") Long id) {
        return inscriptionService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ApiOperation(value = "Obtains all inscriptions.")
    public List<Inscription> getAll() {
        return inscriptionService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains all inscriptions with the specified state.")
    public List<Inscription> getInscriptionsByState(@RequestParam("state") String state) {
        return inscriptionService.getInscriptionsByState(InscriptionState.valueOf(state));
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates a new inscription.")
    public Inscription insert(@RequestBody Inscription inscription) {
        return inscriptionService.insert(inscription);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Update an existing inscription.")
    public Inscription update(@RequestBody Inscription inscription) {
        return inscriptionService.update(inscription);
    }

}
