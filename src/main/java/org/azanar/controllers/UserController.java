package org.azanar.controllers;

import org.azanar.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/user")
public class UserController {
    @Autowired UserData userData;

    @GetMapping("/")
    public String renderOverview() {
        return "overview";
    }
}
