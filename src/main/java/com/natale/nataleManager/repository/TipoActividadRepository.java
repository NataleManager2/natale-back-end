package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.TipoActividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoActividadRepository extends CrudRepository<TipoActividad, Long> {
    List<TipoActividad> findAll();
}
