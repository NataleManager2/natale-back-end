package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Activity;
import com.natale.nataleManager.model.enums.ActivityState;
import com.natale.nataleManager.repository.ActivityRepository;
import com.natale.nataleManager.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActivityServiceImpl implements ActivityService {

    private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity get(Long id) {
        Optional<Activity> act = Optional.of(new Activity());
        try{
            act = activityRepository.findById(id);
            log.debug("findOne activity id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne activity with id: "+id);
        }
        return act.orElse(null);
    }

    @Override
    public Activity insert(Activity act) {
        return activityRepository.save(act);
    }

    @Override
    public List<Activity> getAll() {
        return activityRepository.findAllByState(ActivityState.EN_CURSO);
    }

    @Override
    public Activity update(Activity act) {
        try {
            if (act.getNullAtributes().size() == 0) {
                return activityRepository.save(act);
            }
        } catch (IllegalAccessException e) {
            log.error("La Activity no se actualizo porque tenia atributos nulos: "+ e);
        }

        return act;
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }


}
