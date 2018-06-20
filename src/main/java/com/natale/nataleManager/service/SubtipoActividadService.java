package com.natale.nataleManager.service;

import com.natale.nataleManager.model.SubtipoActividad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubtipoActividadService {
    SubtipoActividad get(Long id) throws Exception;
    SubtipoActividad insert(SubtipoActividad subtipoActividad) throws Exception;
    List<SubtipoActividad> getAll() throws Exception;
    SubtipoActividad update(SubtipoActividad subtipoActividad) throws Exception;
    void delete(Long id) throws Exception;
}
