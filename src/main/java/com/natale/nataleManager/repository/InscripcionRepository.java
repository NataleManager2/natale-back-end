package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Inscripcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends CrudRepository<Inscripcion, Long> {
    List<Inscripcion> findAll();
}