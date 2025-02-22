package org.azanar.controllers;

import org.azanar.models.UserDTO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {
    //@Autowired UserData userData;
    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String renderOverview(@ModelAttribute UserDTO userDTO) {
        return "overview";
    }
}
