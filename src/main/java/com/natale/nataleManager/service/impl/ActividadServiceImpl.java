package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Actividad;
import com.natale.nataleManager.model.Cliente;
import com.natale.nataleManager.repository.ActividadRepository;
import com.natale.nataleManager.repository.ClienteRepository;
import com.natale.nataleManager.service.ActividadService;
import com.natale.nataleManager.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActividadServiceImpl implements ActividadService {

    private static final Logger log = LoggerFactory.getLogger(ActividadServiceImpl.class);

    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadServiceImpl(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @Override
    public Actividad get(Long id) throws Exception {
        Actividad act = new Actividad();
        try{
            act = actividadRepository.findOne(id);
            log.debug("findOne activity id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne activity with id: "+id);
        }
        return act;
    }

    @Override
    public Actividad insert(Actividad act) throws Exception {
        return actividadRepository.save(act);
    }

    @Override
    public List<Actividad> getAll() throws Exception {
        return actividadRepository.findAllByActBorrada(false);
    }

    @Override
    public Actividad update(Actividad act) throws Exception {
        if (act.getNullAtributes().size() == 0) {
            return actividadRepository.save(act);
        }
        log.error("La Actividad no se actualizo porque tenia los siguientes atributos nulos: "+ act.getNullAtributes());
        return act;
    }

    @Override
    public void delete(Long id) throws Exception {
        actividadRepository.delete(id);
    }


}
