package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.repository.ClienteRepository;
import com.natale.nataleManager.model.Cliente;
import com.natale.nataleManager.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClienteServiceImpl implements ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente get(Long id) throws Exception {
        Cliente cliente = new Cliente();
        try{
            cliente = clienteRepository.findOne(id);
            log.debug("findOne client id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne client with id: "+id);
        }
        return cliente;
    }

    @Override
    public Cliente insert(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        return clienteRepository.findAllByCliBorrado(false);
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }


}