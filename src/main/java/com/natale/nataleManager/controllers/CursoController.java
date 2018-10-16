package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.Curso;
import com.natale.nataleManager.service.CursoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/curso")
@Api(tags = {"curso"})
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un Curso.")
    public Curso get(@RequestParam("id") Long id) {
        return cursoService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los cursos.")
    public Iterable<Curso> getAll() {
        return cursoService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo Curso")
    public Curso insert(@RequestBody Curso curso) {
        return cursoService.insert(curso);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un Curso")
    public Curso update(@RequestBody Curso curso) {
        return cursoService.update(curso);
    }

}
