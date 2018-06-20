package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.ObraSocial;
import com.natale.nataleManager.service.ObraSocialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/obrasocial")
@Api(tags = {"obra-social"})
public class ObraSocialController {

    private final ObraSocialService obraSocialService;

    @Autowired
    public ObraSocialController(ObraSocialService obraSocialService) {
        this.obraSocialService = obraSocialService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una Obra Social.")
    public ObraSocial get(@RequestParam("id") Long id) throws Exception {
        return obraSocialService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todas las obras sociales.")
    public List<ObraSocial> getAll() throws Exception {
        return obraSocialService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo obraSocial")
    public ObraSocial insert(@RequestBody ObraSocial obraSocial) throws Exception {
        return obraSocialService.insert(obraSocial);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un obraSocial")
    public ObraSocial update(@RequestBody ObraSocial obraSocial) throws Exception {
        return obraSocialService.update(obraSocial);
    }

}
