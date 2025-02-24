package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.exceptions.DuplicateEmailException;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("login")
    public String renderLogin(@ModelAttribute UserDTO userDTO) {
        return "/login";
    }

    @GetMapping("register")
    public String renderRegister(@ModelAttribute UserDTO userDTO) {
        return "/register";
    }

    @PostMapping("register")
    public String register(
            @Valid @ModelAttribute UserDTO userDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return renderRegister(userDTO);
        }


        try {
            userService.create(userDTO, false);
        } catch (DuplicateEmailException e) {
            result.rejectValue("email", "error", "Email je již používán.");
            System.out.println("Email already in use!");
            return "/register";
        } catch (PasswordsDoNotEqualException e) {
            result.rejectValue("password", "error", "Hesla se nerovnají.");
            result.rejectValue("confirmPassword", "error", "Hesla se nerovnají.");
            System.out.println("Passwords do not match!");
            return "/register";
        }

        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/login";
    }

}
