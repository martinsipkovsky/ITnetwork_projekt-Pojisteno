package org.azanar.models;

import java.util.Objects;

public class CreateUser {

        private String email;
        private String password;
        private String password2;
        private String username;
        private String telephone;
        private String surename;
        private String lastname;
        private Boolean valid;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
            setUsername(email.split("@")[0]);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPassword2(String password2) {
            this.password2 = password2;

            this.valid = (Objects.equals(this.password, this.password2));
        }

        public String getPassword2() {
            return password2;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setSurename(String surename) {
            this.surename = surename;
        }

        public String getSurename() {
            return surename;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getTelephone() {
            return telephone;
        }

}
