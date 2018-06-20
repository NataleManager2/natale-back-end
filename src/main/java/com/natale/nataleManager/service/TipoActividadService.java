package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Actividad;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ActividadService {
    Actividad get(Long id) throws Exception;
    Actividad insert(Actividad actividad) throws Exception;
    List<Actividad> getAll() throws Exception;
    Actividad update(Actividad actividad) throws Exception;
    void delete(Long id) throws Exception;
}
