package com.natale.nataleManager.rest.resources;

import com.natale.nataleManager.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activities", itemResourceRel = "activity", path = "/api/resource/activities")
public interface ActivityRestResource extends PagingAndSortingRepository<Activity, Long> {
    Activity findByName(@Param("name") String name);
}
