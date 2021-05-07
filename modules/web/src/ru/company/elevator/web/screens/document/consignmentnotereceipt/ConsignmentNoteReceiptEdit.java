package ru.company.elevator.web.screens.document.consignmentnotereceipt;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.document.ConsignmentNoteReceipt;

@UiController("elevator_ConsignmentNoteReceipt.edit")
@UiDescriptor("consignment-note-receipt-edit.xml")
@EditedEntityContainer("consignmentNoteReceiptDc")
@LoadDataBeforeShow
public class ConsignmentNoteReceiptEdit extends StandardEditor<ConsignmentNoteReceipt> {
}