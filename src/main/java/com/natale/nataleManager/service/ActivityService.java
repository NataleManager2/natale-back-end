package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    Activity get(Long id);
    Activity insert(Activity activity);
    List<Activity> getAll();
    Activity update(Activity activity);
    void delete(Activity activity);
}
