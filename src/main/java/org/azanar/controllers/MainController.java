package org.azanar.controllers;

import org.azanar.Models;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login_req")
    public @ResponseBody String loginForm(Model model) {
        model.addAttribute("login", new Models.Login());
        return "200";
    }

    @PostMapping("/login_req")
    public @ResponseBody String loginSubmit(@ModelAttribute Models.Login login, Model model) {
        model.addAttribute("login", login);
        return "200";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


}


