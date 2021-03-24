package ru.company.elevator.entity.document;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT")
@Entity(name = "elevator_ConsignmentNoteConsignment")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@NamePattern("%s|number")
public class ConsignmentNoteConsignment extends BaseConsignmentNote {
    private static final long serialVersionUID = -7613015234200240974L;

    @Column(name = "LEFT_")
    private Double left;

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }
}