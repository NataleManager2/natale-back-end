package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Taller;
import com.natale.nataleManager.model.enums.EstadoActividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TallerRepository extends CrudRepository<Taller, Long> {
    List<Taller> findAllByEstado(EstadoActividad estadoActividad);
}
