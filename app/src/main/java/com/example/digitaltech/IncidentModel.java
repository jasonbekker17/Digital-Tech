package com.example.digitaltech;

public class IncidentModel {
    private String email,incident,firstname,lastname,gender;
    private int id,phone_number;

    @Override
    public String toString() {
        return "IncidentModel{" +
                "email='" + email + '\'' +
                ", incident='" + incident + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", phone_number=" + phone_number +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public IncidentModel(String email, String incident, String firstname, String lastname, String gender, int id, int phone_number) {
        this.email = email;
        this.incident = incident;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.id = id;
        this.phone_number = phone_number;
    }
}
