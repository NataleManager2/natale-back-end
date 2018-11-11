package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Customer;
import com.natale.nataleManager.model.enums.CustomerState;
import com.natale.nataleManager.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
@Api(tags = {"customers"})
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Obtains a customer by id.")
    public Customer get(@PathVariable("id") Long id) {
        return customerService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains a list of all customers by CustomerState.")
    public List<Customer> getAllByState(@RequestParam("state") CustomerState state) {
        return customerService.getAllByState(state);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates a new customer.")
    public Customer insert(@RequestBody Customer customer) {
        return customerService.insert(customer);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Updates a customer.")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

}
