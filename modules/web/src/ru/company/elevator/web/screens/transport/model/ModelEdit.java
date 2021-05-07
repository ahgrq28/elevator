package ru.company.elevator.web.screens.transport.model;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.transport.Model;

@UiController("elevator_Model.edit")
@UiDescriptor("model-edit.xml")
@EditedEntityContainer("modelDc")
@LoadDataBeforeShow
public class ModelEdit extends StandardEditor<Model> {
}