package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Calendario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarioService {
    Calendario get(Long id) throws Exception;
    Calendario insert(Calendario calendario) throws Exception;
    List<Calendario> getAllByCurId(Long curId) throws Exception;
    Calendario update(Calendario calendario) throws Exception;
    void delete(Long id) throws Exception;
}
