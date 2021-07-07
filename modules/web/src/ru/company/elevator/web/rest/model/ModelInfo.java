package ru.company.elevator.web.rest.model;

import ru.company.elevator.entity.transport.Model;

public class ModelInfo {

    private String name;
    private String description;


    public ModelInfo() {
    }

    public ModelInfo(Model model) {
        this.name = model.getName();
        this.description = model.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
