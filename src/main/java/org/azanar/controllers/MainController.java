package org.azanar.controllers;

import org.azanar.models.CreateUser;
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
    public String loginPage(Model model) {
        model.addAttribute("user", new CreateUser());
        return "login";
    }


    @PostMapping("/login_req")
    public @ResponseBody String loginSubmit(Model model) {
        CreateUser user = new CreateUser();
        model.addAttribute("user", user);
        return  " welcome! " + user.getUsername();
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute CreateUser user) {
        return "register";
    }


}


