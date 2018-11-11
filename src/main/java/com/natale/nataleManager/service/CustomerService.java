package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer get(Long id);
    Customer insert(Customer customer);
    Iterable<Customer> getAll();
    Customer update(Customer customer);
    void delete(Customer customer);
}
