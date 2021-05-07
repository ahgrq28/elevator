package ru.company.elevator.web.screens.transport.vehicle;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.transport.Vehicle;

@UiController("elevator_Vehicle.browse")
@UiDescriptor("vehicle-browse.xml")
@LookupComponent("vehiclesTable")
@LoadDataBeforeShow
public class VehicleBrowse extends StandardLookup<Vehicle> {
}