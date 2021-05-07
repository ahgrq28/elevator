package ru.company.elevator.web.screens.medicalexamination;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.medical.MedicalExamination;

@UiController("elevator_MedicalExamination.edit")
@UiDescriptor("medical-examination-edit.xml")
@EditedEntityContainer("medicalExaminationDc")
@LoadDataBeforeShow
public class MedicalExaminationEdit extends StandardEditor<MedicalExamination> {
}