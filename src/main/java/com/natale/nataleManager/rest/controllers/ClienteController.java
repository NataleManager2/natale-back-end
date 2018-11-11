package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Customer;
import com.natale.nataleManager.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cliente")
@Api(tags = {"clientes"})
public class ClienteController {

    private final CustomerService customerService;

    @Autowired
    public ClienteController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene un cliente.")
    public Customer get(@RequestParam("id") Long id) {
        return customerService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todos los clientes activos.")
    public Iterable<Customer> getAll() {
        return customerService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo customer")
    public Customer insert(@RequestBody Customer customer) {
        return customerService.insert(customer);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un customer")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

}
