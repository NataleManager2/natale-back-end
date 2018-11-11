package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long> {
    List<Calendar> findAllById(Long id);
}
