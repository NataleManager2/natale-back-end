package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Cliente;
import com.natale.nataleManager.model.enums.EstadoCliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
