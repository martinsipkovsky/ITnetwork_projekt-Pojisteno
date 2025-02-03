package org.azanar.controllers;

import org.azanar.Models;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("login", new Models.Login());
        return "200";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute Models.Login login, Model model) {
        model.addAttribute("login", login);
        return "200";
    }

    @GetMapping("login_btn")
    public @ResponseBody String loginPage() {
        return "login.html";
    }
}


