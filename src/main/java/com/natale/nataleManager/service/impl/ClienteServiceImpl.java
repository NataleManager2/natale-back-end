package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Cliente;
import com.natale.nataleManager.repository.ClienteRepository;
import com.natale.nataleManager.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteServiceImpl implements ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente get(Long id) {
        Optional<Cliente> cliente = Optional.of(new Cliente());
        try{
            cliente = clienteRepository.findById(id);
            log.debug("findOne client id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne client with id: "+id);
        }
        return cliente.orElse(null);
    }

    @Override
    public Cliente insert(Cliente cliente)  {
        return clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente update(Cliente cliente)  {
        try {
            if (cliente.getNullAtributes().size() == 0) {
                return clienteRepository.save(cliente);
            }
        } catch (IllegalAccessException e) {
            log.error("El cliente no se actualizo porque tenia atributos nulos");
        }

        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }


}
