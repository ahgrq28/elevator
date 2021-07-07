package ru.company.elevator.web.rest.model;

import ru.company.elevator.entity.organization.Organization;

public class OrganizationInfo {

    private String inn;
    private String kpp;
    private String shortName;
    private String name;

    public OrganizationInfo() {
    }

    public OrganizationInfo(Organization organization) {
        this.inn = organization.getInn();
        this.kpp = organization.getKpp();
        this.shortName = organization.getShortName();
        this.name = organization.getName();
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
