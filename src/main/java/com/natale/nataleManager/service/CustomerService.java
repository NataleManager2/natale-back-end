package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Customer;
import com.natale.nataleManager.model.enums.CustomerState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer get(Long id);
    Customer insert(Customer customer);
    List<Customer> getAllByState(CustomerState state);
    Customer update(Customer customer);
    void delete(Customer customer);
}
