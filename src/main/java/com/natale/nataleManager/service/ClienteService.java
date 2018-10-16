package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Cliente get(Long id);
    Cliente insert(Cliente cliente);
    Iterable<Cliente> getAll();
    Cliente update(Cliente cliente);
    void delete(Long id);
}
