package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Calendar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarService {
    Calendar get(Long id);
    Calendar insert(Calendar calendar);
    List<Calendar> getAllByCurId(Long curId);
    Calendar update(Calendar calendar);
    void delete(Calendar calendar);
}
