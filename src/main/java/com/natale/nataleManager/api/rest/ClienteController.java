package com.natale.nataleManager.api.rest;

import com.natale.nataleManager.domain.Cliente;
import com.natale.nataleManager.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/cliente")
@Api(tags = {"clientes"})
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un cliente nuevo.")
    public void insert(@RequestBody Cliente cliente,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cliente clienteNuevo = new Cliente();
        try {
            clienteNuevo = clienteService.insert(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
