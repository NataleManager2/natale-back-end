package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.SubtipoActividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtipoActividadRepository extends CrudRepository<SubtipoActividad, Long> {
    List<SubtipoActividad> findAll();
}
