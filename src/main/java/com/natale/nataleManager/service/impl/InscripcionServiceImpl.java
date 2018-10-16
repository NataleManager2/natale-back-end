package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Inscripcion;
import com.natale.nataleManager.model.enums.EstadoInscripcion;
import com.natale.nataleManager.repository.InscripcionRepository;
import com.natale.nataleManager.service.InscripcionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InscripcionServiceImpl implements InscripcionService {

    private static final Logger log = LoggerFactory.getLogger(InscripcionServiceImpl.class);

    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Inscripcion get(Long id) {
        Optional<Inscripcion> inscripcion = Optional.of(new Inscripcion());
        try {
            inscripcion = inscripcionRepository.findById(id);
            log.debug("findOne inscripcion id: " + id + " succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne inscripcion with id: " + id);
        }
        return inscripcion.orElse(null);
    }

    @Override
    public Inscripcion insert(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripcion> getAll() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion update(Inscripcion inscripcion) {
        try {
            if (inscripcion.getNullAtributes().size() == 0) {
                return inscripcionRepository.save(inscripcion);
            }
        } catch (IllegalAccessException e) {
            log.error("La inscripcion no se actualizo porque tenia atributos nulos: "+ e);
        }

        return inscripcion;
    }

    @Override
    public void delete(Inscripcion inscripcion) {
        inscripcionRepository.delete(inscripcion);
    }

    @Override
    public List<Inscripcion> getInscripcionesByEstado(EstadoInscripcion estadoInscripcion) {
        return inscripcionRepository.findAllByEstado(estadoInscripcion);
    }


}
