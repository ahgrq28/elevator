package ru.company.elevator.entity.medical;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "ELEVATOR_MEDICAL_EXAMINATION")
@Entity(name = "elevator_MedicalExamination")
public class MedicalExamination extends StandardEntity {
    private static final long serialVersionUID = -4195536726229853564L;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDICAL_USER_ID")
    private User medicalUser;

    public User getMedicalUser() {
        return medicalUser;
    }

    public void setMedicalUser(User medicalUser) {
        this.medicalUser = medicalUser;
    }

    public MedicalStatus getStatus() {
        return status == null ? null : MedicalStatus.fromId(status);
    }

    public void setStatus(MedicalStatus status) {
        this.status = status == null ? null : status.getId();
    }
}