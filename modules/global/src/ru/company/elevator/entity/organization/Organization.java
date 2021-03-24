package ru.company.elevator.entity.organization;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "ELEVATOR_ORGANIZATION")
@Entity(name = "elevator_Organization")
@NamePattern("%s|shortName")
public class Organization extends StandardEntity {
    private static final long serialVersionUID = -2144452823756501995L;

    @Column(name = "INN")
    private String inn;

    @Column(name = "KPP")
    private String kpp;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}