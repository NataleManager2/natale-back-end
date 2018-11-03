package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Actividad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "actividades", path = "/api/resource/actividad")
public interface ActividadRestResource extends PagingAndSortingRepository<Actividad, Long> {
    
}
