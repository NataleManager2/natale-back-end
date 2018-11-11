package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Calendar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "calendars", itemResourceRel = "calendar", path = "/api/resource/calendars")
public interface CalendarRestResource extends PagingAndSortingRepository<Calendar, Long> {
    Calendar findByDateBetween(@Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta);
}
