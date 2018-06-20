package com.natale.nataleManager.controllers;

import com.natale.nataleManager.model.Cliente;
import com.natale.nataleManager.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
@Api(tags = {"clientes"})
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un cliente.")
    public Cliente get(@RequestParam("id") Long id) throws Exception {
        return clienteService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los clientes activos.")
    public List<Cliente> getAll() throws Exception {
        return clienteService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo cliente")
    public Cliente insert(@RequestBody Cliente cliente) throws Exception {
        return clienteService.insert(cliente);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un cliente")
    public Cliente update(@RequestBody Cliente cliente) throws Exception {
        return clienteService.update(cliente);
    }

}
