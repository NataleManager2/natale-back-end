package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Calendario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalendarioRepository extends CrudRepository<Calendario, Long> {
    List<Calendario> findAllByCalCurso_CurId(Long curId);
}
