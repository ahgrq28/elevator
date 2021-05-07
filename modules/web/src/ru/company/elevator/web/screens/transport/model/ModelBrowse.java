package ru.company.elevator.web.screens.transport.model;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.transport.Model;

@UiController("elevator_Model.browse")
@UiDescriptor("model-browse.xml")
@LookupComponent("modelsTable")
@LoadDataBeforeShow
public class ModelBrowse extends StandardLookup<Model> {
}