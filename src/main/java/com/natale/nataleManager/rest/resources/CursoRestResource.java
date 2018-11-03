package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Curso;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cursos", path = "/api/resource/curso")
public interface CursoRestResource extends PagingAndSortingRepository<Curso, Long> {
    
}
