package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Workshop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "talleres", path = "/api/resource/taller")
public interface WorkshopRestResource extends PagingAndSortingRepository<Workshop, Long> {
    
}
