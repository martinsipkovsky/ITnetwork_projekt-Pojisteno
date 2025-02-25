package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class InsuranceDTO {
    @NotBlank(message = "Vyplňte obsah")
    private long id;

    @NotBlank(message = "Vyplňte obsah")
    private String insuranceType;

    @NotBlank(message = "Vyplňte obsah")
    private String suma;

    @NotBlank(message = "Vyplňte obsah")
    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private Date created;

    @NotBlank(message = "Vyplňte obsah")
    private Date expires;

    @NotBlank(message = "Vyplňte obsah")
    private String phoneNumber;

    public void setCreated(@NotBlank(message = "Vyplňte obsah") Date created) {
        this.created = created;
    }

    public void setSuma(@NotBlank(message = "Vyplňte obsah") String suma) {
        this.suma = suma;
    }

    public void setId(@NotBlank(message = "Vyplňte obsah") long id) {
        this.id = id;
    }

    public void setInsuranceType(@NotBlank(message = "Vyplňte obsah") String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setPhoneNumber(@NotBlank(message = "Vyplňte obsah") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setExpires(@NotBlank(message = "Vyplňte obsah") Date expires) {
        this.expires = expires;
    }

    public void setEmail(@NotBlank(message = "Vyplňte obsah") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Vyplňte obsah") Date getCreated() {
        return created;
    }

    public @NotBlank(message = "Vyplňte obsah") String getSuma() {
        return suma;
    }

    public @NotBlank(message = "Vyplňte obsah") long getId() {
        return id;
    }

    public @NotBlank(message = "Vyplňte obsah") String getInsuranceType() {
        return insuranceType;
    }

    public @NotBlank(message = "Vyplňte obsah") String getPhoneNumber() {
        return phoneNumber;
    }

    public @NotBlank(message = "Vyplňte obsah") Date getExpires() {
        return expires;
    }

    public @NotBlank(message = "Vyplňte obsah") String getEmail() {
        return email;
    }
}
