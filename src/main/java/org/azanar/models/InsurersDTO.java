package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

public class InsurersDTO {
    @NotBlank(message = "Vyplňte obsah")
    private String firstname;

    @NotBlank(message = "Vyplňte obsah")
    private String lastname;

    @NotBlank(message = "Vyplňte obsah")
    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private String phoneNumber;

    @NotBlank(message = "Vyplňte obsah")
    private String street;

    @NotBlank(message = "Vyplňte obsah")
    private String city;

    @NotBlank(message = "Vyplňte obsah")
    private String postalCode;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
