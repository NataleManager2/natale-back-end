package com.natale.nataleManager.dao.jpa;

import com.natale.nataleManager.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
    Page<Cliente> findAll(Pageable pageable);
}
