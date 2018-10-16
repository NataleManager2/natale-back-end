package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Inscripcion;
import com.natale.nataleManager.model.enums.EstadoInscripcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscripcionService {
    Inscripcion get(Long id);
    Inscripcion insert(Inscripcion ins);
    List<Inscripcion> getAll();
    Inscripcion update(Inscripcion ins);
    void delete(Inscripcion inscripcion);
    List<Inscripcion> getInscripcionesByEstado(EstadoInscripcion estadoInscripcion);
}
