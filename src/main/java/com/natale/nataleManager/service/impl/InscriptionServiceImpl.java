package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Inscription;
import com.natale.nataleManager.model.enums.InscriptionState;
import com.natale.nataleManager.repository.InscriptionRepository;
import com.natale.nataleManager.service.InscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InscriptionServiceImpl implements InscriptionService {

    private static final Logger log = LoggerFactory.getLogger(InscriptionServiceImpl.class);

    private final InscriptionRepository inscriptionRepository;

    @Autowired
    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription get(Long id) {
        Optional<Inscription> inscripcion = Optional.of(new Inscription());
        try {
            inscripcion = inscriptionRepository.findById(id);
            log.debug("findOne inscripcion id: " + id + " succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne inscripcion with id: " + id);
        }
        return inscripcion.orElse(null);
    }

    @Override
    public Inscription insert(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> getAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription update(Inscription inscription) {
        try {
            if (inscription.getNullAtributes().size() == 0) {
                return inscriptionRepository.save(inscription);
            }
        } catch (IllegalAccessException e) {
            log.error("La inscription no se actualizo porque tenia atributos nulos: "+ e);
        }

        return inscription;
    }

    @Override
    public void delete(Inscription inscription) {
        inscriptionRepository.delete(inscription);
    }

    @Override
    public List<Inscription> getInscriptionsByState(InscriptionState inscriptionState) {
        return inscriptionRepository.findAllByState(inscriptionState);
    }


}
