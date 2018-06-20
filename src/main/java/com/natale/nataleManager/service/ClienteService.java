package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Cliente get(Long id) throws Exception;
    Cliente insert(Cliente cliente) throws Exception;
    List<Cliente> getAll() throws Exception;
    Cliente update(Cliente cliente) throws Exception;
    void delete(Long id) throws Exception;
}
