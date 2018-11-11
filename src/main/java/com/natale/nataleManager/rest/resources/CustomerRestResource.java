package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@Secured("USER")
@RepositoryRestResource(collectionResourceRel = "customers", itemResourceRel = "customer", path = "/api/resource/customers")
public interface CustomerRestResource extends PagingAndSortingRepository<Customer, Long> {

//    @Secured("ADMIN")
    Customer findByDni(@Param("dni") Long dni);

}
