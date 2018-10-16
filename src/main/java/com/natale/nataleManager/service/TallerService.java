package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Taller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TallerService {
    Taller get(Long id);
    Taller insert(Taller taller);
    List<Taller> getAll();
    Taller update(Taller taller);
    void delete(Long id);
}
