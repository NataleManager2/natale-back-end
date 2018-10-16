package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Actividad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActividadService {
    Actividad get(Long id);
    Actividad insert(Actividad actividad);
    List<Actividad> getAll();
    Actividad update(Actividad actividad);
    void delete(Long id);
}
