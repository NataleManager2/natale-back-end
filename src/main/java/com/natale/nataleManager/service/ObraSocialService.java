package com.natale.nataleManager.service;

import com.natale.nataleManager.model.ObraSocial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObraSocialService {
    ObraSocial get(Long id);
    ObraSocial insert(ObraSocial os);
    List<ObraSocial> getAll();
    ObraSocial update(ObraSocial os);
    void delete(ObraSocial obraSocial);
}
