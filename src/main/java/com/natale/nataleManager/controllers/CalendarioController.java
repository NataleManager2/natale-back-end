package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.Calendario;
import com.natale.nataleManager.service.CalendarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/calendario")
@Api(tags = {"calendario"})
public class CalendarioController {

    private final CalendarioService calendarioService;

    @Autowired
    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Calendario.")
    public Calendario get(@RequestParam("id") Long id) {
        return calendarioService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los calendarios.")
    public List<Calendario> getAllByCurId(Long curId) {
        return calendarioService.getAllByCurId(curId);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Calendario")
    public Calendario insert(@RequestBody Calendario calendario) {
        return calendarioService.insert(calendario);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Calendario")
    public Calendario update(@RequestBody Calendario calendario) {
        return calendarioService.update(calendario);
    }

}
