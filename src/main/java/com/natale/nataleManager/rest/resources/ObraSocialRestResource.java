package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Inscripcion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "obrassociales", path = "/api/resource/obrasocial")
public interface ObraSocialRestResource extends PagingAndSortingRepository<Inscripcion, Long> {
    
}
