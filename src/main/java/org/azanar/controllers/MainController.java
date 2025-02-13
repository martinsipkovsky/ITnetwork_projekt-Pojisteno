package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("user", new UserDTO());
        return "login";
    }


    @PostMapping("/login_req")
    public @ResponseBody String loginSubmit(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return  " welcome! " + user.getUsername();
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
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

        return "redirect:/";
    }



}


