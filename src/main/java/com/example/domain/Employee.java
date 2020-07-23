package com.example.domain;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Employee {
    @Schema(description = "Employee first name")
    private String firstName;

    @Schema(description = "Employee Last name")
    private String lastName;

    @Schema(description = "Employee email")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
