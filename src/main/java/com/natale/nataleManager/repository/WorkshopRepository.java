package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Workshop;
import com.natale.nataleManager.model.enums.ActivityState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
    List<Workshop> findAllByState(ActivityState activityState);
}
