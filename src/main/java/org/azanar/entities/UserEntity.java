package org.azanar.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class UserEntity implements UserDetails {
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
    private String heslo;

    @Column(nullable = false)
    private boolean admin;

    // region: UserDetails Methods
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return heslo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + (admin ? "ADMIN" : "USER"));
        return List.of(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // endregion

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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }
}
