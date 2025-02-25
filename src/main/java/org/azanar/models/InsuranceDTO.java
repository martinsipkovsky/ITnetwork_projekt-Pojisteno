package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class InsuranceDTO {
    @NotBlank(message = "Vyplňte obsah")
    private long userId;

    @NotBlank(message = "Vyplňte obsah")
    private String insuranceType;

    @NotBlank(message = "Vyplňte obsah")
    private String suma;

    @NotBlank(message = "Vyplňte obsah")
    private String item;

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

    public void setUserId(@NotBlank(message = "Vyplňte obsah") long userId) {
        this.userId = userId;
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

    public void setItem(@NotBlank(message = "Vyplňte obsah") String item) {
        this.item = item;
    }

    public @NotBlank(message = "Vyplňte obsah") Date getCreated() {
        return created;
    }

    public @NotBlank(message = "Vyplňte obsah") String getSuma() {
        return suma;
    }

    public @NotBlank(message = "Vyplňte obsah") long getUserId() {
        return userId;
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

    public @NotBlank(message = "Vyplňte obsah") String getItem() {
        return item;
    }
}
