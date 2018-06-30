package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Calendario;
import com.natale.nataleManager.repository.CalendarioRepository;
import com.natale.nataleManager.repository.CursoRepository;
import com.natale.nataleManager.service.CalendarioService;
import com.natale.nataleManager.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalendarioServiceImpl implements CalendarioService {

    private static final Logger log = LoggerFactory.getLogger(CalendarioServiceImpl.class);

    private final CalendarioRepository calendarioRepository;
    @Autowired
    public CalendarioServiceImpl(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    public Calendario get(Long id) throws Exception {
        Calendario calendario = new Calendario();
        try{
            calendario = calendarioRepository.findOne(id);
            log.debug("findOne calendario id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne calendario with id: "+id);
        }
        return calendario;
    }

    @Override
    public Calendario insert(Calendario calendario) throws Exception {
        return calendarioRepository.save(calendario);
    }

    @Override
    public List<Calendario> getAllByCurId(Long curId) throws Exception {
        return calendarioRepository.findAllByCalCurso_CurId(curId);
    }

    @Override
    public Calendario update(Calendario calendario) throws Exception {
        if (calendario.getNullAtributes().size() == 0) {
            return calendarioRepository.save(calendario);
        }
        log.error("El calendario no se actualizo porque tenia los siguientes atributos nulos: "+ calendario.getNullAtributes());
        return calendario;
    }

    @Override
    public void delete(Long id) {
        calendarioRepository.delete(id);
    }


}
