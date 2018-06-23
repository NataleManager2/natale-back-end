package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Taller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TallerRepository extends CrudRepository<Taller, Long> {
    List<Taller> findAllByTaActivo(boolean b);
}
