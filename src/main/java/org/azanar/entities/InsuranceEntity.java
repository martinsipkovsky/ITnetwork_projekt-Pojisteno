package org.azanar.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String insuranceType;

    @Column(nullable = false)
    private String suma;

    @Column(nullable = false)
    private String insuranceDescription;

    @Column(nullable = false)
    private String created;

    @Column(nullable = false)
    private String expires;

    public String getCreated() {
        return created;
    }

    public String getExpires() {
        return expires;
    }

    public long getContractId() {
        return contractId;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getItem() {
        return insuranceDescription;
    }

    public String getSuma() {
        return suma;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setItem(String item) {
        this.insuranceDescription = item;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setInsuranceDescription(String insuranceDescription) {
        this.insuranceDescription = insuranceDescription;
    }

    public String getInsuranceDescription() {
        return insuranceDescription;
    }
}
