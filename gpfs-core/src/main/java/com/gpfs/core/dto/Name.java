package com.gpfs.core.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Created by jbvillanueva on 5/21/17.
 */
@Embeddable
public class Name {

    @Column(name = "title")
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    public Name(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
    }

    @Override
    public String toString() {
        StringBuilder nameAsString = new StringBuilder();
        if (null != lastName) {
            nameAsString.append(lastName);
        }
        if (nameAsString.length() > 0 && (isNotEmpty(firstName) || isNotEmpty(middleName))) {
            nameAsString.append(", ");
        }
        if (isNotEmpty(firstName)) {
            nameAsString.append(firstName);
        }
        if (isNotEmpty(middleName)) {
            nameAsString.append(" ").append(middleName);
        }
        return nameAsString.length() > 0 ? nameAsString.toString() : "No name provided";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return lastName;
    }

    public void setSurname(String surname) {
        this.lastName = surname;
    }

}
