package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.ObraSocial;
import com.natale.nataleManager.repository.ObraSocialRepository;
import com.natale.nataleManager.service.ObraSocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObraSocialServiceImpl implements ObraSocialService {

    private static final Logger log = LoggerFactory.getLogger(ObraSocialServiceImpl.class);

    private final ObraSocialRepository obraSocialRepository;
    @Autowired
    public ObraSocialServiceImpl(ObraSocialRepository obraSocialRepository) {
        this.obraSocialRepository = obraSocialRepository;
    }

    @Override
    public ObraSocial get(Long id) {
        Optional<ObraSocial> obraSocial = Optional.of(new ObraSocial());
        try{
            obraSocial = obraSocialRepository.findById(id);
            log.debug("findOne obraSocial id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne obraSocial with id: "+id);
        }
        return obraSocial.orElse(null);
    }

    @Override
    public ObraSocial insert(ObraSocial obraSocial) {
        return obraSocialRepository.save(obraSocial);
    }

    @Override
    public List<ObraSocial> getAll() {
        return obraSocialRepository.findAll();
    }

    @Override
    public ObraSocial update(ObraSocial obraSocial) {
        try {
            if (obraSocial.getNullAtributes().size() == 0) {
                return obraSocialRepository.save(obraSocial);
            }
        } catch (IllegalAccessException e) {
            log.error("La obraSocial no se actualizo porque tenia atributos nulos: "+ e);
        }

        return obraSocial;
    }

    @Override
    public void delete(ObraSocial obraSocial) {
        obraSocialRepository.delete(obraSocial);
    }


}
