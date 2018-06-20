package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.SubtipoActividad;
import com.natale.nataleManager.repository.SubtipoActividadRepository;
import com.natale.nataleManager.service.SubtipoActividadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SubtipoActividadServiceImpl implements SubtipoActividadService {

    private static final Logger log = LoggerFactory.getLogger(SubtipoActividadServiceImpl.class);

    private final SubtipoActividadRepository subtipoActividadRepository;

    @Autowired
    public SubtipoActividadServiceImpl(SubtipoActividadRepository subtipoActividadRepository) {
        this.subtipoActividadRepository = subtipoActividadRepository;
    }

    @Override
    public SubtipoActividad get(Long id) throws Exception {
        SubtipoActividad act = new SubtipoActividad();
        try{
            act = subtipoActividadRepository.findOne(id);
            log.debug("findOne SubtipoActividad id: "+id+" succesful");
        } catch (Exception e) {
            log.error("failed findingOne SubtipoActividad with id: "+id+" - Error:"+e.getMessage());
        }
        return act;
    }

    @Override
    public SubtipoActividad insert(SubtipoActividad act) throws Exception {
        return subtipoActividadRepository.save(act);
    }

    @Override
    public List<SubtipoActividad> getAll() throws Exception {
        return subtipoActividadRepository.findAll();
    }

    @Override
    public SubtipoActividad update(SubtipoActividad act) throws Exception {
        return subtipoActividadRepository.save(act);
    }

    @Override
    public void delete(Long id) throws Exception {
        subtipoActividadRepository.delete(id);
    }


}
