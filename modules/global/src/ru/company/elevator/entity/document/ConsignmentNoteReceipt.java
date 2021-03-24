package ru.company.elevator.entity.document;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Table(name = "ELEVATOR_CONSIGNMENT_NOTE_RECEIPT")
@Entity(name = "elevator_ConsignmentNoteReceipt")
@PrimaryKeyJoinColumn(name = "ID")
@NamePattern("%s|number")
public class ConsignmentNoteReceipt extends BaseConsignmentNote {
    private static final long serialVersionUID = -5939396214670817051L;

    @NotNull
    @Column(name = "COMING", nullable = false)
    @DecimalMin("0")
    private Double coming;

    @Column(name = "WEEDINESS")
    @DecimalMin("0")
    @DecimalMax("100")
    private Double weediness;

    @Column(name = "HUMIDITY")
    @DecimalMin("0")
    @DecimalMax("100")
    private Double humidity;

    public void setWeediness(Double weediness) {
        this.weediness = weediness;
    }

    public Double getWeediness() {
        return weediness;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getComing() {
        return coming;
    }

    public void setComing(Double coming) {
        this.coming = coming;
    }
}