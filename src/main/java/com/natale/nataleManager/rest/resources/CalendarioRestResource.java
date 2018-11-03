package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Calendario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "calendarios", path = "/api/resource/calendario")
public interface CalendarioRestResource extends PagingAndSortingRepository<Calendario, Long> {
    
}
