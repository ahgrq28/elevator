package ru.company.elevator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.UUID;

@Validated
public class VehicleDto implements Serializable {
    private static final long serialVersionUID = -3421904158277884749L;

    @JsonProperty("number")
    private String number;
    @JsonProperty("modelId")
    private UUID modelId;
    @JsonProperty("userId")
    private UUID userId;
    @JsonProperty("organizationId")
    private UUID organizationId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }
}
