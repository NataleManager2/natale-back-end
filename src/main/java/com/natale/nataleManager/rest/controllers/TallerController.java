package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Taller;
import com.natale.nataleManager.service.TallerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/taller")
@Api(tags = {"taller"})
public class TallerController {

    private final TallerService tallerService;

    @Autowired
    public TallerController(TallerService tallerService) {
        this.tallerService = tallerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Taller.")
    public Taller get(@RequestParam("id") Long id) {
        return tallerService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los Talleres.")
    public List<Taller> getAll() {
        return tallerService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Taller")
    public Taller insert(@RequestBody Taller taller) {
        return tallerService.insert(taller);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Taller")
    public Taller update(@RequestBody Taller taller) {
        return tallerService.update(taller);
    }

}
