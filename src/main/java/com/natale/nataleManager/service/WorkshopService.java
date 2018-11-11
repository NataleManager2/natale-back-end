package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Workshop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkshopService {
    Workshop get(Long id);
    Workshop insert(Workshop workshop);
    List<Workshop> getAll();
    Workshop update(Workshop workshop);
    void delete(Workshop workshop);
}
