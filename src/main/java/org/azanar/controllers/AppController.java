package org.azanar.controllers;

import org.azanar.entities.UserEntity;
import org.azanar.models.InsuranceDTO;
import org.azanar.models.UserDTO;
import org.azanar.models.UserService;
import org.azanar.models.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {
    //@Autowired UserData userData;
    @Autowired
    private UserService userService;

    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String renderOverview(Authentication auth, Model model) {
        UserEntity user = (UserEntity) userService.loadUserByUsername(auth.getName());
        model.addAttribute("user", user);
        return "overview";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute InsuranceDTO insuranceDTO) {
        return "create-insurance";
    }
}
