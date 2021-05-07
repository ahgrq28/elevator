package ru.company.elevator.web.screens.transport.vehicle;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.transport.Vehicle;

@UiController("elevator_Vehicle.edit")
@UiDescriptor("vehicle-edit.xml")
@EditedEntityContainer("vehicleDc")
@LoadDataBeforeShow
public class VehicleEdit extends StandardEditor<Vehicle> {
}