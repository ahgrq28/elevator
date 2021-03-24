package ru.company.elevator.entity.transport;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;
import ru.company.elevator.entity.organization.Organization;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Table(name = "ELEVATOR_VEHICLE")
@Entity(name = "elevator_Vehicle")
@NamePattern("%s|number")
public class Vehicle extends StandardEntity {
    private static final long serialVersionUID = -1709555758047205931L;

    @Column(name = "GOVERNMENT_NUMBER")
    @Pattern(regexp = "U###UU##*")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_ID")
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}