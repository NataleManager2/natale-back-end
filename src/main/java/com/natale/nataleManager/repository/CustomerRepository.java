package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Customer;
import com.natale.nataleManager.model.enums.CustomerState;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findAllByState(CustomerState state);
}
