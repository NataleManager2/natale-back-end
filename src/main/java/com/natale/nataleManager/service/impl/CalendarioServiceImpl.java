package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Calendario;
import com.natale.nataleManager.repository.CalendarioRepository;
import com.natale.nataleManager.service.CalendarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CalendarioServiceImpl implements CalendarioService {

    private static final Logger log = LoggerFactory.getLogger(CalendarioServiceImpl.class);

    private final CalendarioRepository calendarioRepository;
    @Autowired
    public CalendarioServiceImpl(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    public Calendario get(Long id) {
        Optional<Calendario> calendario = Optional.of(new Calendario());
        try{
            calendario = calendarioRepository.findById(id);
            log.debug("findOne calendario id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne calendario with id: "+id);
        }
        return calendario.orElse(null);
    }

    @Override
    public Calendario insert(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    @Override
    public List<Calendario> getAllByCurId(Long curId) {
        return calendarioRepository.findAllById(curId);
    }

    @Override
    public Calendario update(Calendario calendario) {
        try {
            if (calendario.getNullAtributes().size() == 0) {
                return calendarioRepository.save(calendario);
            }
        } catch (IllegalAccessException e) {
            log.error("El calendario no se actualizo porque tenia atributos nulos: "+ e);
        }

        return calendario;
    }

    @Override
    public void delete(Calendario calendario) {
        calendarioRepository.delete(calendario);
    }


}
