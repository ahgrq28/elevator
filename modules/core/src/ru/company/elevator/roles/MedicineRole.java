package ru.company.elevator.roles;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.app.role.annotation.ScreenComponentAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenComponentPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import ru.company.elevator.entity.document.BaseConsignmentNote;
import ru.company.elevator.entity.document.ConsignmentNoteConsignment;
import ru.company.elevator.entity.document.ConsignmentNoteReceipt;
import ru.company.elevator.entity.medical.MedicalExamination;

@Role(name = "medicine",
        description = "Роль медицинского работника"
)
public class MedicineRole extends AnnotatedRoleDefinition {

    @ScreenAccess(screenIds = {
            "overhead",
            "organization",
            "elevator_ConsignmentNoteConsignment.browse",
            "elevator_ConsignmentNoteConsignment.edit",
            "elevator_ConsignmentNoteReceipt.browse",
            "elevator_ConsignmentNoteReceipt.edit",
            "elevator_MedicalExamination.edit",
            "elevator_Organization.browse",
            "elevator_Organization.edit"
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityName = "*", operations = {EntityOp.READ})
    @EntityAccess(entityClass = BaseConsignmentNote.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = ConsignmentNoteConsignment.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = ConsignmentNoteReceipt.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = MedicalExamination.class, operations = {EntityOp.READ, EntityOp.UPDATE, EntityOp.CREATE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityName = "*", view = "*")
    @EntityAttributeAccess(entityClass = BaseConsignmentNote.class, modify = "*")
    @EntityAttributeAccess(entityClass = ConsignmentNoteConsignment.class, modify = "*")
    @EntityAttributeAccess(entityClass = ConsignmentNoteReceipt.class, modify = "*")
    @EntityAttributeAccess(entityClass = MedicalExamination.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenComponentAccess(screenId = "elevator_ConsignmentNoteConsignment.browse", deny = {"createBtn", "editBtn", "removeBtn"})
    @ScreenComponentAccess(screenId = "elevator_ConsignmentNoteReceipt.browse", deny = {"createBtn", "editBtn", "removeBtn"})
    @Override
    public ScreenComponentPermissionsContainer screenComponentPermissions() {
        return super.screenComponentPermissions();
    }

    @Override
    public String getLocName() {
        return "Медецинский работник";
    }
}
