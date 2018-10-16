package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Taller;
import com.natale.nataleManager.model.enums.EstadoActividad;
import com.natale.nataleManager.repository.TallerRepository;
import com.natale.nataleManager.service.TallerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TallerServiceImpl implements TallerService {

    private static final Logger log = LoggerFactory.getLogger(TallerServiceImpl.class);

    private final TallerRepository tallerRepository;
    @Autowired
    public TallerServiceImpl(TallerRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }

    @Override
    public Taller get(Long id) {
        Taller taller = new Taller();
        try{
            taller = tallerRepository.findOne(id);
            log.debug("findOne taller id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne taller with id: "+id);
        }
        return taller;
    }

    @Override
    public Taller insert(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public List<Taller> getAll() {
        return tallerRepository.findAllByEstado(EstadoActividad.EN_CURSO);
    }

    @Override
    public Taller update(Taller taller)  {
        try {
            if (taller.getNullAtributes().size() == 0) {
                return tallerRepository.save(taller);
            }
        } catch (IllegalAccessException e) {
            log.error("El taller no se actualizo porque tenia atributos nulos: "+ e);
        }

        return taller;
    }

    @Override
    public void delete(Long id) {
        tallerRepository.delete(id);
    }


}
