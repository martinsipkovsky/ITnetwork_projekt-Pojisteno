package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.azanar.models.UserService;

@Controller
public class AccountController {
    private UserService userService;

    @GetMapping("login")
    public String renderLogin(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/login";
    }

    @GetMapping("register")
    public String renderRegister(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String createArticle(
            @Valid @ModelAttribute UserDTO user,
            BindingResult result
    ) {
        //if (result.hasErrors())
        //return renderCreateForm(article);

        // Zde budeme později pracovat s databází
        System.out.println(user.getEmail() + " – " + user.getTelephone()); // <-- TENTO ŘÁDEK NÁS ZAJÍMÁ
        userService.create(user);

        return "redirect:/";
    }

}
