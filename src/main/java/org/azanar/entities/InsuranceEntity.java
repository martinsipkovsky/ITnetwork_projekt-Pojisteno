package org.azanar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @GeneratedValue
    private long userId;

    @GeneratedValue
    private String insuranceType;

    @GeneratedValue
    private String suma;

    @GeneratedValue
    private String item;

    @GeneratedValue
    private Date created;

    @GeneratedValue
    private Date expires;

    public long getUserId() {
        return userId;
    }

    public Date getCreated() {
        return created;
    }

    public Date getExpires() {
        return expires;
    }

    public long getContractId() {
        return contractId;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getItem() {
        return item;
    }

    public String getSuma() {
        return suma;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }
}
