package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Inscription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inscriptions", itemResourceRel = "inscription", path = "/api/resource/inscriptions")
public interface InscriptionsRestResource extends PagingAndSortingRepository<Inscription, Long> {
    
}
