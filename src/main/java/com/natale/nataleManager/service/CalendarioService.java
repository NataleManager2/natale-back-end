package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Calendario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarioService {
    Calendario get(Long id);
    Calendario insert(Calendario calendario);
    List<Calendario> getAllByCurId(Long curId);
    Calendario update(Calendario calendario);
    void delete(Calendario calendario);
}
