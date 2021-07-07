package ru.company.elevator.roles;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.SpecificAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;

@Role(name = "restApi", securityScope = "REST",
        description = "Роль restApi", isSuper = true
)
public class RestApiRole extends AnnotatedRoleDefinition {

    @EntityAccess(entityName = "*", operations = {EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE, EntityOp.CREATE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityName = "*", view = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @Override
    @SpecificAccess(permissions = {"cuba.restApi.enabled"})
    public SpecificPermissionsContainer specificPermissions() {
        return super.specificPermissions();
    }
}
