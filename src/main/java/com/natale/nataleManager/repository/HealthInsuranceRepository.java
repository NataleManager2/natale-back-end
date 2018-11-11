package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.HealthInsurance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthInsuranceRepository extends PagingAndSortingRepository<HealthInsurance, Long> {
    List<HealthInsurance> findAll();
}
