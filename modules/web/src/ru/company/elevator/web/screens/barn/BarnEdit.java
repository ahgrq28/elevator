package ru.company.elevator.web.screens.barn;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.Barn;

@UiController("elevator_Barn.edit")
@UiDescriptor("barn-edit.xml")
@EditedEntityContainer("barnDc")
@LoadDataBeforeShow
public class BarnEdit extends StandardEditor<Barn> {
}