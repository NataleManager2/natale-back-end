package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Inscripcion;
import com.natale.nataleManager.repository.InscripcionRepository;
import com.natale.nataleManager.service.InscripcionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InscripcionServiceImpl implements InscripcionService {

    private static final Logger log = LoggerFactory.getLogger(InscripcionServiceImpl.class);

    private final InscripcionRepository inscripcionRepository;
    @Autowired
    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Inscripcion get(Long id) throws Exception {
        Inscripcion inscripcion = new Inscripcion();
        try{
            inscripcion = inscripcionRepository.findOne(id);
            log.debug("findOne inscripcion id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne inscripcion with id: "+id);
        }
        return inscripcion;
    }

    @Override
    public Inscripcion insert(Inscripcion inscripcion) throws Exception {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripcion> getAll() throws Exception {
        return inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion update(Inscripcion inscripcion) throws Exception {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void delete(Long id) {
        inscripcionRepository.delete(id);
    }


}
