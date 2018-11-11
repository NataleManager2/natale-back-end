package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Inscription;
import com.natale.nataleManager.model.enums.InscriptionState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Long> {
    List<Inscription> findAll();
    List<Inscription> findAllByState(InscriptionState inscriptionState);
}
