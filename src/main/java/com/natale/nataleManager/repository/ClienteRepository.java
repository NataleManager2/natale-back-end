package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByCliNombre(String nombre);
    Cliente findAllByCliNombre(String nombre);
    List<Cliente> findAllByCliBorrado(boolean b);
}
