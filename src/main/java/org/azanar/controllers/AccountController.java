package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.exceptions.DuplicateEmailException;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.azanar.models.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("register")
    public String register(
            @Valid @ModelAttribute UserDTO userDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        model.addAttribute("user", new UserDTO());
        if (result.hasErrors())
            return renderRegister(model);

        try {
            userService.create(userDTO, false);
        } catch (DuplicateEmailException e) {
            result.rejectValue("email", "error", "Email je již používán.");
            return "/register";
        } catch (PasswordsDoNotEqualException e) {
            result.rejectValue("password", "error", "Hesla se nerovnají.");
            result.rejectValue("confirmPassword", "error", "Hesla se nerovnají.");
            return "/register";
        }

        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/login";
    }

}
