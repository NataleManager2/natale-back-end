package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
    List<Curso> findAllByCurActivo(boolean b);
}
