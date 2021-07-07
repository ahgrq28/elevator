package ru.company.elevator.web.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("elevator_VehicleController")
@RequestMapping("/vehicle")
public class VehicleController {


    @GetMapping("/custom")
    public String getCustomVehicle(@PathVariable String entityName,
                                   @PathVariable String entityId,
                                   @RequestParam(required = false) String view,
                                   @RequestParam(required = false) Boolean returnNulls,
                                   @RequestParam(required = false) Boolean dynamicAttributes,
                                   @RequestParam(required = false) String modelVersion) {
        return entitiesControllerManager.loadEntity(entityName, entityId, view, returnNulls, dynamicAttributes, modelVersion);
    }
}
