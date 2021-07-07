package ru.company.elevator.web.rest.model;

import com.haulmont.cuba.security.entity.User;

public class UserInfo {

    public String id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String position;
    public String email;
    public String timeZone;
    public String language;

    public UserInfo(User user) {
        this.id = user.getId().toString();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.position = user.getPosition();
        this.email = user.getEmail();
        this.timeZone = user.getTimeZone();
        this.language = user.getLanguage();
    }
}
