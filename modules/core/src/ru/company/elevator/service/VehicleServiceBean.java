package ru.company.elevator.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;
import ru.company.elevator.dto.VehicleDto;
import ru.company.elevator.entity.organization.Organization;
import ru.company.elevator.entity.transport.Model;
import ru.company.elevator.entity.transport.Vehicle;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static com.haulmont.cuba.core.global.View.LOCAL;

@Service(VehicleService.NAME)
public class VehicleServiceBean implements VehicleService {

    @Inject
    private UserSessionSource userSessionSource;

    @Inject
    private Metadata metadata;

    @Inject
    private DataManager dataManager;

    @Override
    public List<Vehicle> retrieveVehicleByUser() {
        return retrieveVehicleByUser(LOCAL);
    }

    @Override
    public List<Vehicle> retrieveVehicleByUser(String view) {
        UUID userId = userSessionSource.getUserSession().getUser().getId();
        return retrieveVehicleByUser(userId, view);
    }

    @Override
    public List<Vehicle> retrieveVehicleByUser(UUID userId) {
        return retrieveVehicleByUser(userId, LOCAL);
    }

    @Override
    public List<Vehicle> retrieveVehicleByUser(UUID userId, String view) {
        return dataManager.load(Vehicle.class)
                .query("select v from elevator_Vehicle v where v.user.id = :userId")
                .parameter("userId", userId)
                .view(view)
                .list();
    }

    @Override
    public Vehicle createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = metadata.create(Vehicle.class);
        vehicle.setNumber(vehicleDto.getNumber());
        vehicle.setModel(dataManager.getReference(Model.class, vehicleDto.getModelId()));
        vehicle.setUser(dataManager.getReference(User.class, vehicleDto.getUserId()));
        vehicle.setOrganization(dataManager.getReference(Organization.class, vehicleDto.getOrganizationId()));
        return dataManager.commit(vehicle);
    }
}