package com.natale.nataleManager.service;

import com.natale.nataleManager.model.HealthInsurance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HealthInsuranceService {
    HealthInsurance get(Long id);
    HealthInsurance insert(HealthInsurance os);
    List<HealthInsurance> getAll();
    HealthInsurance update(HealthInsurance os);
    void delete(HealthInsurance healthInsurance);
}
