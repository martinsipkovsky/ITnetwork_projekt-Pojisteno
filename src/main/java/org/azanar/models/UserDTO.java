package org.azanar.models;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Vyplňte obsah")
    private String email;

    @NotBlank(message = "Vyplňte obsah")
    private String password;

    @NotBlank(message = "Vyplňte obsah")
    private String confirmPassword;

    @NotBlank(message = "Vyplňte obsah")
    private String phoneNumber;

    @NotBlank(message = "Vyplňte obsah")
    private String firstname;

    @NotBlank(message = "Vyplňte obsah")
    private String lastname;

    public String getEmail() {
            return email;
        }

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getFirstname() {return firstname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getLastname() {return lastname;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
