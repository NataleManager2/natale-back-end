package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Inscripcion;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InscripcionService {
    Inscripcion get(Long id) throws Exception;
    Inscripcion insert(Inscripcion ins) throws Exception;
    List<Inscripcion> getAll() throws Exception;
    Inscripcion update(Inscripcion ins) throws Exception;
    void delete(Long id) throws Exception;
}
