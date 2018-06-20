package com.natale.nataleManager.service;

import com.natale.nataleManager.model.ObraSocial;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ObraSocialService {
    ObraSocial get(Long id) throws Exception;
    ObraSocial insert(ObraSocial os) throws Exception;
    List<ObraSocial> getAll() throws Exception;
    ObraSocial update(ObraSocial os) throws Exception;
    void delete(Long id) throws Exception;
}
