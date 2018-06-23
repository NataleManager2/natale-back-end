package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Taller;
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
    public Taller get(Long id) throws Exception {
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
    public Taller insert(Taller taller) throws Exception {
        return tallerRepository.save(taller);
    }

    @Override
    public List<Taller> getAll() throws Exception {
        return tallerRepository.findAllByTaActivo(true);
    }

    @Override
    public Taller update(Taller taller) throws Exception {
        return tallerRepository.save(taller);
    }

    @Override
    public void delete(Long id) {
        tallerRepository.delete(id);
    }


}
