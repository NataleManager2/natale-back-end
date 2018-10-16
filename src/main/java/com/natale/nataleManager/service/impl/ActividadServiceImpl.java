package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Actividad;
import com.natale.nataleManager.model.enums.EstadoActividad;
import com.natale.nataleManager.repository.ActividadRepository;
import com.natale.nataleManager.service.ActividadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActividadServiceImpl implements ActividadService {

    private static final Logger log = LoggerFactory.getLogger(ActividadServiceImpl.class);

    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadServiceImpl(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @Override
    public Actividad get(Long id) {
        Optional<Actividad> act = Optional.of(new Actividad());
        try{
            act = actividadRepository.findById(id);
            log.debug("findOne activity id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne activity with id: "+id);
        }
        return act.orElse(null);
    }

    @Override
    public Actividad insert(Actividad act) {
        return actividadRepository.save(act);
    }

    @Override
    public List<Actividad> getAll() {
        return actividadRepository.findAllByEstado(EstadoActividad.EN_CURSO);
    }

    @Override
    public Actividad update(Actividad act) {
        try {
            if (act.getNullAtributes().size() == 0) {
                return actividadRepository.save(act);
            }
        } catch (IllegalAccessException e) {
            log.error("La Actividad no se actualizo porque tenia atributos nulos: "+ e);
        }

        return act;
    }

    @Override
    public void delete(Actividad actividad) {
        actividadRepository.delete(actividad);
    }


}
