package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;

@Secured("USER")
@RepositoryRestResource(collectionResourceRel = "clientes", path = "cliente")
public interface ClienteRestResource extends PagingAndSortingRepository<Cliente, Long> {

    @Secured("ADMIN")
    @RestResource(path = "/deleteByDni")
    Cliente deleteByDni(@Param("dni") Long dni);

}
