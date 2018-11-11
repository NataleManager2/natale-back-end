package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Customer;
import com.natale.nataleManager.repository.CustomerRepository;
import com.natale.nataleManager.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer get(Long id) {
        Optional<Customer> cliente = Optional.of(new Customer());
        try{
            cliente = customerRepository.findById(id);
            log.debug("findOne client id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne client with id: "+id);
        }
        return cliente.orElse(null);
    }

    @Override
    public Customer insert(Customer customer)  {
        return customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer)  {
        try {
            if (customer.getNullAtributes().size() == 0) {
                return customerRepository.save(customer);
            }
        } catch (IllegalAccessException e) {
            log.error("El customer no se actualizo porque tenia atributos nulos");
        }

        return customer;
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }


}
