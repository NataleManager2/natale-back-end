package com.natale.nataleManager.service;

import com.natale.nataleManager.model.TipoActividad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoActividadService {
    TipoActividad get(Long id) throws Exception;
    TipoActividad insert(TipoActividad tipoActividad) throws Exception;
    List<TipoActividad> getAll() throws Exception;
    TipoActividad update(TipoActividad tipoActividad) throws Exception;
    void delete(Long id) throws Exception;
}
