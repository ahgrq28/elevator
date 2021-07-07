package ru.company.elevator.service;

import ru.company.elevator.dto.VehicleDto;
import ru.company.elevator.entity.transport.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {
    String NAME = "elevator_VehicleService";

    List<Vehicle> retrieveVehicleByUser();

    List<Vehicle> retrieveVehicleByUser(UUID userId);

    Vehicle createVehicle(VehicleDto vehicleDto);
}