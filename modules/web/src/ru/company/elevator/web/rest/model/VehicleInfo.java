package ru.company.elevator.web.rest.model;

import ru.company.elevator.entity.transport.Vehicle;

public class VehicleInfo {

    private String number;
    private ModelInfo model;
    private UserInfo user;
    private OrganizationInfo organization;

    public VehicleInfo() {
    }

    public VehicleInfo(Vehicle vehicle) {
        this.number = vehicle.getNumber();
        this.model = new ModelInfo(vehicle.getModel());
        this.user = new UserInfo(vehicle.getUser());
        this.organization = new OrganizationInfo(vehicle.getOrganization());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ModelInfo getModel() {
        return model;
    }

    public void setModel(ModelInfo model) {
        this.model = model;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public OrganizationInfo getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationInfo organization) {
        this.organization = organization;
    }
}
