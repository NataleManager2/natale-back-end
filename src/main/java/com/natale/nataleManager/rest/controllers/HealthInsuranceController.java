package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.HealthInsurance;
import com.natale.nataleManager.service.HealthInsuranceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/healthInsurances")
@Api(tags = {"healthInsurances"})
public class HealthInsuranceController {

    private final HealthInsuranceService healthInsuranceService;

    @Autowired
    public HealthInsuranceController(HealthInsuranceService healthInsuranceService) {
        this.healthInsuranceService = healthInsuranceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ApiOperation(value = "Obtains a Health Insurance.")
    public HealthInsurance get(@PathVariable("id") Long id) {
        return healthInsuranceService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains a list of all Health insurances.")
    public List<HealthInsurance> getAll() {
        return healthInsuranceService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates a healthInsurance")
    public HealthInsurance insert(@RequestBody HealthInsurance healthInsurance) {
        return healthInsuranceService.insert(healthInsurance);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Updates a healthInsurance")
    public HealthInsurance update(@RequestBody HealthInsurance healthInsurance) {
        return healthInsuranceService.update(healthInsurance);
    }

}
