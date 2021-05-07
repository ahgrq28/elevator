package ru.company.elevator.web.screens.document.consignmentnoteconsignment;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.document.ConsignmentNoteConsignment;
import ru.company.elevator.entity.medical.MedicalExamination;

import javax.inject.Inject;

@UiController("elevator_ConsignmentNoteConsignment.browse")
@UiDescriptor("consignment-note-consignment-browse.xml")
@LookupComponent("consignmentNoteConsignmentsTable")
@LoadDataBeforeShow
public class ConsignmentNoteConsignmentBrowse extends StandardLookup<ConsignmentNoteConsignment> {

    @Inject
    private Metadata metadata;
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<ConsignmentNoteConsignment> consignmentNoteConsignmentsTable;

    @Subscribe("consignmentNoteConsignmentsTable.medical")
    public void onConsignmentNoteConsignmentsTableMedical(Action.ActionPerformedEvent event) {
        ConsignmentNoteConsignment consignmentNoteConsignment = consignmentNoteConsignmentsTable.getSingleSelected();
        MedicalExamination medicalExamination = consignmentNoteConsignment.getMedicalExamination();
        if(medicalExamination == null){
            medicalExamination = metadata.create(MedicalExamination.class);
            consignmentNoteConsignment.setMedicalExamination(medicalExamination);
        }

        screenBuilders.editor(MedicalExamination.class, this)
                .editEntity(medicalExamination)
                .build()
                .show();
    }
}