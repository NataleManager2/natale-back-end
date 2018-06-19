package com.natale.nataleManager.service;

import com.natale.nataleManager.domain.Cliente;

public interface ClienteService {
    Cliente get(Long id) throws Exception;
    Cliente insert(Cliente cliente) throws Exception;
}
