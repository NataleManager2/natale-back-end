package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Calendar;
import com.natale.nataleManager.repository.CalendarRepository;
import com.natale.nataleManager.service.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CalendarServiceImpl implements CalendarService {

    private static final Logger log = LoggerFactory.getLogger(CalendarServiceImpl.class);

    private final CalendarRepository calendarRepository;
    @Autowired
    public CalendarServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Calendar get(Long id) {
        Optional<Calendar> calendario = Optional.of(new Calendar());
        try{
            calendario = calendarRepository.findById(id);
            log.debug("findOne calendario id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne calendario with id: "+id);
        }
        return calendario.orElse(null);
    }

    @Override
    public Calendar insert(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public List<Calendar> getAllByCurId(Long curId) {
        return calendarRepository.findAllById(curId);
    }

    @Override
    public Calendar update(Calendar calendar) {
        try {
            if (calendar.getNullAtributes().size() == 0) {
                return calendarRepository.save(calendar);
            }
        } catch (IllegalAccessException e) {
            log.error("El calendar no se actualizo porque tenia atributos nulos: "+ e);
        }

        return calendar;
    }

    @Override
    public void delete(Calendar calendar) {
        calendarRepository.delete(calendar);
    }


}
