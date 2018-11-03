package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Inscripcion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inscripciones", path = "/api/resource/inscripcion")
public interface InscripcionRestResource extends PagingAndSortingRepository<Inscripcion, Long> {
    
}
