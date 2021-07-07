package ru.company.elevator.web.rest.controller;

import com.haulmont.addon.restapi.api.service.filter.data.ResponseInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.company.elevator.dto.VehicleDto;
import ru.company.elevator.entity.transport.Vehicle;
import ru.company.elevator.service.VehicleService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController("elevator_VehicleController")
@RequestMapping("/vehicle")
public class VehicleController {

    @Inject
    private VehicleService vehicleService;


    @GetMapping()
    public List<VehicleDto> getVehicleByCurrentUser() {
        List<Vehicle> vehicles = vehicleService.retrieveVehicleByUser("vehicle-dto");
        return vehicles.stream()
                .map(this::createVehicleDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public List<VehicleDto> loadEntity(@PathVariable UUID userId) {
        List<Vehicle> vehicles = vehicleService.retrieveVehicleByUser(userId, "vehicle-dto");
        return vehicles.stream()
                .map(this::createVehicleDto)
                .collect(Collectors.toList());
    }

    protected VehicleDto createVehicleDto(Vehicle vehicle){
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setNumber(vehicle.getNumber());
        vehicleDto.setModelId(vehicle.getModel().getId());
        vehicleDto.setOrganizationId(vehicle.getOrganization().getId());
        vehicleDto.setUserId(vehicle.getUser().getId());
        return vehicleDto;
    }
}
