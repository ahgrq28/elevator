package ru.company.elevator.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import ru.company.elevator.entity.organization.Organization;

@UiController("elevator_Organization.browse")
@UiDescriptor("organization-browse.xml")
@LookupComponent("organizationsTable")
@LoadDataBeforeShow
public class OrganizationBrowse extends StandardLookup<Organization> {
}