package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.HealthInsurance;
import com.natale.nataleManager.service.HealthInsuranceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/obrasocial")
@Api(tags = {"obra-social"})
public class ObraSocialController {

    private final HealthInsuranceService healthInsuranceService;

    @Autowired
    public ObraSocialController(HealthInsuranceService healthInsuranceService) {
        this.healthInsuranceService = healthInsuranceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una Obra Social.")
    public HealthInsurance get(@RequestParam("id") Long id) {
        return healthInsuranceService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listado")
    @ApiOperation(value = "Obtiene un listado de todas las obras sociales.")
    public List<HealthInsurance> getAll() {
        return healthInsuranceService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo healthInsurance")
    public HealthInsurance insert(@RequestBody HealthInsurance healthInsurance) {
        return healthInsuranceService.insert(healthInsurance);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un healthInsurance")
    public HealthInsurance update(@RequestBody HealthInsurance healthInsurance) {
        return healthInsuranceService.update(healthInsurance);
    }

}
