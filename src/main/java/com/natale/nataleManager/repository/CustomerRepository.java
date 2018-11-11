package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
