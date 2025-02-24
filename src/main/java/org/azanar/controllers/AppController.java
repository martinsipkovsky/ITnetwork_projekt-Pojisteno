package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.entities.UserEntity;
import org.azanar.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private InsurersService insurersService;

    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String renderOverview(Authentication auth, Model model) {
        UserEntity user = (UserEntity) userService.loadUserByUsername(auth.getName());
        model.addAttribute("user", user);
        return "overview";
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("/create/insurer")
    public String renderCreateForm(@ModelAttribute InsurersDTO insurersDTO) {
        return "create-insurer";
    }

    @PostMapping("/create/insurer")
    public String processCreateForm(@Valid @ModelAttribute InsurersDTO insurersDTO,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes) {
        insurersService.create(insurersDTO);

        return "redirect:/";
    }
}
