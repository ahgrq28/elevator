package ru.company.elevator.web.screens.ext.mainscreen;

import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.app.main.MainScreen;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
@LoadDataBeforeShow
public class ExtMainScreen extends MainScreen {
}