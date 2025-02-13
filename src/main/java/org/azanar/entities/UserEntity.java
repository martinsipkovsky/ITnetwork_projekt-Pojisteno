package org.azanar.entities;

import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false)
    private String jmeno;

    @Column(nullable = false)
    private String prijmeni;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefon;

    @Column(nullable = false)
    private String datumNarozeni;

    @Column(nullable = false)
    private String heslo;

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public long getUserId() {
        return userId;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public String getEmail() {
        return email;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getHeslo() {
        return heslo;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }
}
