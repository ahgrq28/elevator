package ru.company.elevator.web.uicomponents.stepper;

import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.ValueSource;
import com.haulmont.cuba.web.gui.components.*;

import java.util.Collection;
import java.util.function.Consumer;

@CompositeDescriptor("stepper-component.xml")
public class StepperField
        extends CompositeComponent<HBoxLayout>
        implements Field<Double>,
        CompositeWithCaption,
        CompositeWithHtmlCaption,
        CompositeWithHtmlDescription,
        CompositeWithIcon,
        CompositeWithContextHelp {

    public static final String NAME = "stepperField";

    private TextField<Double> valueField;
    private Button upBtn;
    private Button downBtn;

    private double step = 0.1;

    public StepperField() {
        addCreateListener(this::onCreate);
    }

    private void onCreate(CreateEvent createEvent) {
        valueField = getInnerComponent("valueField");
        upBtn = getInnerComponent("upBtn");
        downBtn = getInnerComponent("downBtn");

        upBtn.addClickListener(clickEvent -> updateValue(step));
        downBtn.addClickListener(clickEvent -> updateValue(-step));
    }

    private void updateValue(double delta) {
        Double value = getValue();
        setValue(value != null ? value + delta : delta);
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    @Override
    public boolean isRequired() {
        return valueField.isRequired();
    }

    @Override
    public void setRequired(boolean required) {
        valueField.setRequired(required);
        getComposition().setRequiredIndicatorVisible(required);
    }

    @Override
    public String getRequiredMessage() {
        return valueField.getRequiredMessage();
    }

    @Override
    public void setRequiredMessage(String msg) {
        valueField.setRequiredMessage(msg);
    }

    @Override
    public void addValidator(Consumer<? super Double> validator) {
        valueField.addValidator(validator);
    }

    @Override
    public void removeValidator(Consumer<Double> validator) {
        valueField.removeValidator(validator);
    }

    @Override
    public Collection<Consumer<Double>> getValidators() {
        return valueField.getValidators();
    }

    @Override
    public boolean isEditable() {
        return valueField.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        valueField.setEditable(editable);
        upBtn.setEnabled(editable);
        downBtn.setEnabled(editable);
    }

    @Override
    public Double getValue() {
        return valueField.getValue();
    }

    @Override
    public void setValue(Double value) {
        valueField.setValue(value);
    }

    @Override
    public Subscription addValueChangeListener(Consumer<ValueChangeEvent<Double>> listener) {
        return valueField.addValueChangeListener(listener);
    }

    @Override
    public void removeValueChangeListener(Consumer<ValueChangeEvent<Double>> listener) {
        valueField.removeValueChangeListener(listener);
    }

    @Override
    public boolean isValid() {
        return valueField.isValid();
    }

    @Override
    public void validate() throws ValidationException {
        valueField.validate();
    }

    @Override
    public void setValueSource(ValueSource<Double> valueSource) {
        valueField.setValueSource(valueSource);
        getComposition().setRequiredIndicatorVisible(valueField.isRequired());
    }

    @Override
    public ValueSource<Double> getValueSource() {
        return valueField.getValueSource();
    }
}