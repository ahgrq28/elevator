package ru.company.elevator.web.screens.medicalexamination;

import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;
import ru.company.elevator.entity.medical.MedicalExamination;

import javax.inject.Inject;

@UiController("elevator_MedicalExamination.edit")
@UiDescriptor("medical-examination-edit.xml")
@EditedEntityContainer("medicalExaminationDc")
@LoadDataBeforeShow
public class MedicalExaminationEdit extends StandardEditor<MedicalExamination> {

    @Inject
    private UserSessionSource userSessionSource;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        User user = userSessionSource.getUserSession().getUser();
        getEditedEntity().setMedicalUser(user);
    }

}