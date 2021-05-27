package ru.company.elevator.web.screens.document.consignmentnoteconsignment;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.CloseAction;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.StandardLookup;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import ru.company.elevator.entity.document.ConsignmentNoteConsignment;
import ru.company.elevator.entity.medical.MedicalExamination;

import javax.inject.Inject;

@UiController("elevator_ConsignmentNoteConsignment.browse")
@UiDescriptor("consignment-note-consignment-browse.xml")
@LookupComponent("consignmentNoteConsignmentsTable")
@LoadDataBeforeShow
public class ConsignmentNoteConsignmentBrowse extends StandardLookup<ConsignmentNoteConsignment> {

    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private CollectionContainer<ConsignmentNoteConsignment> consignmentNoteConsignmentsDc;
    @Inject
    private GroupTable<ConsignmentNoteConsignment> consignmentNoteConsignmentsTable;

    @Subscribe("consignmentNoteConsignmentsTable.medical")
    public void onConsignmentNoteConsignmentsTableMedical(Action.ActionPerformedEvent event) {
        ConsignmentNoteConsignment consignmentNoteConsignment = consignmentNoteConsignmentsTable.getSingleSelected();
        if (consignmentNoteConsignment == null) {
            //todo message
            return;
        }
        MedicalExamination medicalExamination = consignmentNoteConsignment.getMedicalExamination();
        if (medicalExamination == null) {
            medicalExamination = metadata.create(MedicalExamination.class);
            consignmentNoteConsignment.setMedicalExamination(medicalExamination);
        }

        Screen screen = screenBuilders.editor(MedicalExamination.class, this)
                .editEntity(medicalExamination)
                .build();
        screen.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();
            if (closeAction.equals(WINDOW_COMMIT_AND_CLOSE_ACTION)) {
                dataManager.commit(consignmentNoteConsignment);
                consignmentNoteConsignmentsDc.replaceItem(consignmentNoteConsignment);
            }
        });

        screen.show();
    }
}