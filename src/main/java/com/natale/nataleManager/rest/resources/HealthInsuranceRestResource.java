package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.HealthInsurance;
import com.natale.nataleManager.model.Inscription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "healthInsurances", itemResourceRel = "healthInsurance", path = "/api/resource/healthInsurances")
public interface HealthInsuranceRestResource extends PagingAndSortingRepository<HealthInsurance, Long> {
    HealthInsurance findByName(@Param("name") String name);
}
