package ru.company.elevator.entity.document;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.apache.commons.lang3.StringUtils;
import ru.company.elevator.entity.Barn;
import ru.company.elevator.entity.medical.MedicalExamination;
import ru.company.elevator.entity.organization.Organization;
import ru.company.elevator.entity.transport.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "ELEVATOR_CONSIGNMENT_NOTE")
@Entity(name = "elevator_ConsignmentNote")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 60)
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s|number")
public class BaseConsignmentNote extends StandardEntity {
    private static final long serialVersionUID = -2087203247677412992L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    private Integer number;

    @NotNull
    @Column(name = "DATE_", nullable = false)
    private LocalDateTime date;

    @NotNull
    @Column(name = "GRADE", nullable = false)
    @Min(1)
    @Max(5)
    private Integer grade;

    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BARN_ID")
    private Barn barn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @JoinColumn(name = "ORGANIZATION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDICAL_EXAMINATION_ID")
    private MedicalExamination medicalExamination;

    public MedicalExamination getMedicalExamination() {
        return medicalExamination;
    }

    public void setMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExamination = medicalExamination;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    @Transient
    @MetaProperty(related = "number")
    public String getCaption() {
        return StringUtils.defaultString(String.valueOf(number));
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}