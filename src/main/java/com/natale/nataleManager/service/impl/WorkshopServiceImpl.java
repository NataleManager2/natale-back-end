package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Workshop;
import com.natale.nataleManager.model.enums.ActivityState;
import com.natale.nataleManager.repository.WorkshopRepository;
import com.natale.nataleManager.service.WorkshopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WorkshopServiceImpl implements WorkshopService {

    private static final Logger log = LoggerFactory.getLogger(WorkshopServiceImpl.class);

    private final WorkshopRepository tallerRepository;
    @Autowired
    public WorkshopServiceImpl(WorkshopRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }

    @Override
    public Workshop get(Long id) {
        Optional<Workshop> taller = Optional.of(new Workshop());
        try{
            taller = tallerRepository.findById(id);
            log.debug("findOne taller id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne taller with id: "+id);
        }
        return taller.orElse(null);
    }

    @Override
    public Workshop insert(Workshop taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public List<Workshop> getAll() {
        return tallerRepository.findAllByState(ActivityState.EN_CURSO);
    }

    @Override
    public Workshop update(Workshop taller)  {
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
    public void delete(Workshop taller) {
        tallerRepository.delete(taller);
    }


}
