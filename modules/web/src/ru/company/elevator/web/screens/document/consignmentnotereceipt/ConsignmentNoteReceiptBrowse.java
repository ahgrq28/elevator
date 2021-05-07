package ru.company.elevator.web.screens.document.consignmentnotereceipt;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.document.ConsignmentNoteReceipt;

@UiController("elevator_ConsignmentNoteReceipt.browse")
@UiDescriptor("consignment-note-receipt-browse.xml")
@LookupComponent("consignmentNoteReceiptsTable")
@LoadDataBeforeShow
public class ConsignmentNoteReceiptBrowse extends StandardLookup<ConsignmentNoteReceipt> {
}