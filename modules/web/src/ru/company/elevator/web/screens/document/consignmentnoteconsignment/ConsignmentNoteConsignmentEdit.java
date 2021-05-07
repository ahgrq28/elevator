package ru.company.elevator.web.screens.document.consignmentnoteconsignment;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.document.ConsignmentNoteConsignment;

@UiController("elevator_ConsignmentNoteConsignment.edit")
@UiDescriptor("consignment-note-consignment-edit.xml")
@EditedEntityContainer("consignmentNoteConsignmentDc")
@LoadDataBeforeShow
public class ConsignmentNoteConsignmentEdit extends StandardEditor<ConsignmentNoteConsignment> {
}