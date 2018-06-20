package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Page<Cliente> findAll(Pageable pageable);
    List<Cliente> findAllByCliBorrado(boolean b);
}
