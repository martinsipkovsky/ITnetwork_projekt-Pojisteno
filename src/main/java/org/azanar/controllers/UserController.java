package org.azanar.controllers;

import org.azanar.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    //@Autowired UserData userData;

    @GetMapping("/user")
    public String renderOverview(Model model) {
        model.addAttribute("firstname", "Jan");
        model.addAttribute("lastname", "Novák");
        return "overview";
    }
}
