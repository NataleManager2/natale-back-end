package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Activity;
import com.natale.nataleManager.model.enums.ActivityState;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long> {
    List<Activity> findAllByState(ActivityState activityState);
}
