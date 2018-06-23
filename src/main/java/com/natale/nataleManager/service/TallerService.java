package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Taller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TallerService {
    Taller get(Long id) throws Exception;
    Taller insert(Taller taller) throws Exception;
    List<Taller> getAll() throws Exception;
    Taller update(Taller taller) throws Exception;
    void delete(Long id) throws Exception;
}
