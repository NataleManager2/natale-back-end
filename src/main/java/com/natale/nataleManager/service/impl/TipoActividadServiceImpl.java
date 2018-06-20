package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.TipoActividad;
import com.natale.nataleManager.repository.TipoActividadRepository;
import com.natale.nataleManager.service.TipoActividadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TipoActividadServiceImpl implements TipoActividadService {

    private static final Logger log = LoggerFactory.getLogger(TipoActividadServiceImpl.class);

    private final TipoActividadRepository tipoActividadRepository;

    @Autowired
    public TipoActividadServiceImpl(TipoActividadRepository tipoActividadRepository) {
        this.tipoActividadRepository = tipoActividadRepository;
    }

    @Override
    public TipoActividad get(Long id) throws Exception {
        TipoActividad tipoActividad = new TipoActividad();
        try{
            tipoActividad = tipoActividadRepository.findOne(id);
            log.debug("findOne tipoActividad id: "+id+" succesful");
        } catch (Exception e) {
            log.error("failed findingOne tipoActividad with id: "+id+" "+e.getMessage());
        }
        return tipoActividad;
    }

    @Override
    public TipoActividad insert(TipoActividad tipoActividad) throws Exception {
        return tipoActividadRepository.save(tipoActividad);
    }

    @Override
    public List<TipoActividad> getAll() throws Exception {
        return tipoActividadRepository.findAll();
    }

    @Override
    public TipoActividad update(TipoActividad tipoActividad) throws Exception {
        return tipoActividadRepository.save(tipoActividad);
    }

    @Override
    public void delete(Long id) throws Exception {
        tipoActividadRepository.delete(id);
    }


}
