package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.HealthInsurance;
import com.natale.nataleManager.repository.HealthInsuranceRepository;
import com.natale.nataleManager.service.HealthInsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    private static final Logger log = LoggerFactory.getLogger(HealthInsuranceServiceImpl.class);

    private final HealthInsuranceRepository healthInsuranceRepository;
    @Autowired
    public HealthInsuranceServiceImpl(HealthInsuranceRepository healthInsuranceRepository) {
        this.healthInsuranceRepository = healthInsuranceRepository;
    }

    @Override
    public HealthInsurance get(Long id) {
        Optional<HealthInsurance> obraSocial = Optional.of(new HealthInsurance());
        try{
            obraSocial = healthInsuranceRepository.findById(id);
            log.debug("findOne obraSocial id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne obraSocial with id: "+id);
        }
        return obraSocial.orElse(null);
    }

    @Override
    public HealthInsurance insert(HealthInsurance healthInsurance) {
        return healthInsuranceRepository.save(healthInsurance);
    }

    @Override
    public List<HealthInsurance> getAll() {
        return healthInsuranceRepository.findAll();
    }

    @Override
    public HealthInsurance update(HealthInsurance healthInsurance) {
        try {
            if (healthInsurance.getNullAtributes().size() == 0) {
                return healthInsuranceRepository.save(healthInsurance);
            }
        } catch (IllegalAccessException e) {
            log.error("La healthInsurance no se actualizo porque tenia atributos nulos: "+ e);
        }

        return healthInsurance;
    }

    @Override
    public void delete(HealthInsurance healthInsurance) {
        healthInsuranceRepository.delete(healthInsurance);
    }


}
