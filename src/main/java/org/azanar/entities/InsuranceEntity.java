package org.azanar.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String insuranceType;

    @Column(nullable = false)
    private String suma;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private Date created;

    @Column(nullable = false)
    private Date expires;

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
