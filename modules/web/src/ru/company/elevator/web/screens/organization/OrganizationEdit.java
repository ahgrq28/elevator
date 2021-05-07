package ru.company.elevator.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.organization.Organization;

@UiController("elevator_Organization.edit")
@UiDescriptor("organization-edit.xml")
@EditedEntityContainer("organizationDc")
@LoadDataBeforeShow
public class OrganizationEdit extends StandardEditor<Organization> {
}