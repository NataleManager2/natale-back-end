package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Curso;
import com.natale.nataleManager.model.enums.EstadoActividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
    List<Curso> findAllByEstado(EstadoActividad estadoActividad);
}
