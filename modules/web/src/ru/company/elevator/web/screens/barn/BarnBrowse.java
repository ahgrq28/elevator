package ru.company.elevator.web.screens.barn;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.ProgressBar;
import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.Barn;

import javax.inject.Inject;

@UiController("elevator_Barn.browse")
@UiDescriptor("barn-browse.xml")
@LookupComponent("barnsTable")
@LoadDataBeforeShow
public class BarnBrowse extends StandardLookup<Barn> {

    @Inject
    private UiComponents uiComponents;

    @Install(to = "barnsTable.fillingProgress", subject = "columnGenerator")
    private Component barnsTableFillingProgressColumnGenerator(Barn barn) {
        ProgressBar progressBar = uiComponents.create(ProgressBar.class);
        progressBar.setValue(20.0);
        return progressBar;
    }
}