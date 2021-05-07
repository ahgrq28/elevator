package ru.company.elevator.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name = "ELEVATOR_BARN")
@Entity(name = "elevator_Barn")
@NamePattern("%s|number")
public class Barn extends StandardEntity {
    private static final long serialVersionUID = -7701477185478715459L;

    @Column(name = "NUMBER_")
    private String number;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "CAPACITY")
    private Double capacity;

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}