package ru.company.elevator.entity.medical;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MedicalStatus implements EnumClass<String> {

    OPEN("Open"),
    IN_PROGRESS("In progress"),
    SUCCESS("Success"),
    FAIL("Fail");

    private String id;

    MedicalStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MedicalStatus fromId(String id) {
        for (MedicalStatus at : MedicalStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}