package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class InsuranceDTO {
    private long contractId;

    @NotBlank(message = "Vyplňte obsah")
    private String insuranceType;

    @NotBlank(message = "Vyplňte obsah")
    private String suma;

    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private String created;

    @NotBlank(message = "Vyplňte obsah")
    private String expires;

    @NotBlank(message = "Vyplňte obsah")
    private String insuranceDescription;

    public void setCreated(@NotBlank(message = "Vyplňte obsah") String created) {
        this.created = created;
    }

    public void setSuma(@NotBlank(message = "Vyplňte obsah") String suma) {
        this.suma = suma;
    }

    public void setInsuranceType(@NotBlank(message = "Vyplňte obsah") String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setInsuranceDescription(@NotBlank(message = "Vyplňte obsah") String insuranceDescription) {
        this.insuranceDescription = insuranceDescription;
    }

    public void setExpires(@NotBlank(message = "Vyplňte obsah") String expires) {
        this.expires = expires;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @NotBlank(message = "Vyplňte obsah") String getCreated() {
        return created;
    }

    public @NotBlank(message = "Vyplňte obsah") String getSuma() {
        return suma;
    }

    public @NotBlank(message = "Vyplňte obsah") String getInsuranceType() {
        return insuranceType;
    }

    public @NotBlank(message = "Vyplňte obsah") String getInsuranceDescription() {
        return insuranceDescription;
    }

    public @NotBlank(message = "Vyplňte obsah") String getExpires() {
        return expires;
    }

    public String getEmail() {
        return email;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public long getContractId() {
        return contractId;
    }
}
