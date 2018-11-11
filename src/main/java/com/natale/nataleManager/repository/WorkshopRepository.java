package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Workshop;
import com.natale.nataleManager.model.enums.ActivityState;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends PagingAndSortingRepository<Workshop, Long> {
    List<Workshop> findAllByState(ActivityState activityState);
}
