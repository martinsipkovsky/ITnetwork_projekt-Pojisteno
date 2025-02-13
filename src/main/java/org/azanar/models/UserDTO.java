package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Vyplňte obsah")
    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private String password;

    @NotBlank(message = "Vyplňte obsah")
    private String username;

    @NotBlank(message = "Vyplňte obsah")
    private String telephone;

    @NotBlank(message = "Vyplňte obsah")
    private String surename;

    @NotBlank(message = "Vyplňte obsah")
    private String lastname;

    public String getEmail() {
            return email;
        }

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void setUsername(String username) {this.username = username;}

    public String getUsername() {return username;}

    public void setSurename(String surename) {this.surename = surename;}

    public String getSurename() {return surename;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getLastname() {return lastname;}

    public void setTelephone(String telephone) {this.telephone = telephone;}

    public String getTelephone() {return telephone;}

}
