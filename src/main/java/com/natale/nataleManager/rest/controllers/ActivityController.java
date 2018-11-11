package com.natale.nataleManager.rest.controllers;

import com.natale.nataleManager.model.Activity;
import com.natale.nataleManager.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities")
@Api(tags = {"activities"})
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Obtains an Activity by id.")
    public Activity get(@PathVariable("id") Long id) {
        return activityService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Obtains a list of all activities")
    public List<Activity> getAll() {
        return activityService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    @ApiOperation(value = "Creates an Activity")
    public Activity insert(@RequestBody Activity act) {
        return activityService.insert(act);
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ApiOperation(value = "Updates an Activity")
    public Activity update(@RequestBody Activity act) {
        return activityService.update(act);
    }

}
