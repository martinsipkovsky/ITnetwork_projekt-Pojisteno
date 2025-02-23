package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

public class InsuranceDTO {
    @NotBlank(message = "Vyplňte obsah")
    private String firstname;

    @NotBlank(message = "Vyplňte obsah")
    private String lastname;

    @NotBlank(message = "Vyplňte obsah")
    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private String street;

    @NotBlank(message = "Vyplňte obsah")
    private String city;

    @NotBlank(message = "Vyplňte obsah")
    private String postCode;

    @NotBlank(message = "Vyplňte obsah")
    private String phoneNumber;

    public void setCity(@NotBlank(message = "Vyplňte obsah") String city) {
        this.city = city;
    }

    public void setEmail(@NotBlank(message = "Vyplňte obsah") String email) {
        this.email = email;
    }

    public void setFirstname(@NotBlank(message = "Vyplňte obsah") String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(@NotBlank(message = "Vyplňte obsah") String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(@NotBlank(message = "Vyplňte obsah") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostCode(@NotBlank(message = "Vyplňte obsah") String postCode) {
        this.postCode = postCode;
    }

    public void setStreet(@NotBlank(message = "Vyplňte obsah") String street) {
        this.street = street;
    }

    public @NotBlank(message = "Vyplňte obsah") String getCity() {
        return city;
    }

    public @NotBlank(message = "Vyplňte obsah") String getEmail() {
        return email;
    }

    public @NotBlank(message = "Vyplňte obsah") String getFirstname() {
        return firstname;
    }

    public @NotBlank(message = "Vyplňte obsah") String getLastname() {
        return lastname;
    }

    public @NotBlank(message = "Vyplňte obsah") String getPhoneNumber() {
        return phoneNumber;
    }

    public @NotBlank(message = "Vyplňte obsah") String getPostCode() {
        return postCode;
    }

    public @NotBlank(message = "Vyplňte obsah") String getStreet() {
        return street;
    }
}
