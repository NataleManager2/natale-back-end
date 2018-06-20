package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.ObraSocial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepository extends CrudRepository<ObraSocial, Long> {
}
