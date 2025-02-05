package org.azanar;

public class Processor {
    public String parseUsername(String email) {
         return email.split("@")[0];
    }
}
