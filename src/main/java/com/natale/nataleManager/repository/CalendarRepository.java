package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Calendar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends PagingAndSortingRepository<Calendar, Long> {
    List<Calendar> findAllByCourse_Id(Long id);
    List<Calendar> findAll();
}
