package ru.company.elevator.groups;

import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;
import com.haulmont.cuba.security.app.group.annotation.JpqlConstraint;
import com.haulmont.cuba.security.group.ConstraintsContainer;
import ru.company.elevator.entity.document.ConsignmentNoteConsignment;
import ru.company.elevator.entity.document.ConsignmentNoteReceipt;

@AccessGroup(name = "Medical")
public class MedicalGroup extends AnnotatedAccessGroupDefinition {

    @JpqlConstraint(target = ConsignmentNoteConsignment.class, where = "exists(select 1 from elevator_ConsignmentNoteConsignment cnc " +
            "left join cnc.medicalExamination me where (me is null or me.medicalUser.id = :session$userId) and {E}.id = cnc.id)")
    @JpqlConstraint(target = ConsignmentNoteReceipt.class, where = "exists(select 1 from elevator_ConsignmentNoteReceipt cnr " +
            "left join cnr.medicalExamination me where (me is null or me.medicalUser.id = :session$userId) and {E}.id = cnr.id)")
    @Override
    public ConstraintsContainer accessConstraints() {
        return super.accessConstraints();
    }
}
