package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Inscription;
import com.natale.nataleManager.model.enums.InscriptionState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscriptionService {
    Inscription get(Long id);
    Inscription insert(Inscription ins);
    List<Inscription> getAll();
    Inscription update(Inscription ins);
    void delete(Inscription inscription);
    List<Inscription> getInscripcionesByEstado(InscriptionState inscriptionState);
}
