package org.azanar.controllers;

import jakarta.validation.Valid;
import org.azanar.entities.UserEntity;
import org.azanar.models.*;
import org.azanar.repositories.UserRepository;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private InsurersService insurersService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private  InsurersMapper insurersMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String renderOverview(Authentication auth, Model model) {
        UserEntity user = (UserEntity) userService.loadUserByUsername(auth.getName());
        UserDTO userDTO = userMapper.toDTO(user);
        model.addAttribute("user", user);


        return "overview";
    }

    @GetMapping("/user/{email}")
    public String renderOtherUser(@PathVariable String email, Model model) {
        UserDTO user = userService.getByEmail(email);
        model.addAttribute("user", user);

        List<InsuranceDTO> insurance = insuranceService.getByEmail(email);
        model.addAttribute("insurance", insurance);

        return "/overview";
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("/create/insurer")
    public String renderCreateForm(@ModelAttribute InsurersDTO insurersDTO) {
        return "create-insurer";
    }

    @PostMapping("/create/insurer")
    public String processCreateForm(@ModelAttribute InsurersDTO insurersDTO,
                                    BindingResult result) {
        System.out.println("[Request] New insurer -> DB");

        if (result.hasErrors()) {
            System.out.println("[Error] create-insurer (POST)");
        }
        insurersService.create(insurersDTO);

        return "redirect:/insurers";
    }

    @GetMapping("/insurers")
    public String renderInsurers(@ModelAttribute InsurersDTO insurersDTO, Model model) {
        List<InsurersDTO> insurers = insurersService.getAll();
        model.addAttribute("insurers", insurers);
        return "insurers";
    }

    @GetMapping("/edit/insurer/{insurerId}")
    public String renderEditInsurer(@ModelAttribute InsurersDTO insurersDTO,
                                    @PathVariable long insurerId) {
        InsurersDTO fetchedInsurer = insurersService.getById(insurerId);
        insurersMapper.updateInsurersDTO(fetchedInsurer, insurersDTO);
        return "create-insurer";
    }

    @PostMapping("/edit/insurer/{insurerId}")
    public String editInsurer(@ModelAttribute InsurersDTO insurersDTO,
                              @PathVariable long insurerId,
                              BindingResult result) {
        System.out.println("[Request] edit insurer -> DB");

        if (result.hasErrors()) {
            System.out.println("[Error] edit insurer (POST)");
        }

        insurersDTO.setUserId(insurerId);
        insurersService.edit(insurersDTO);

        return "redirect:/insurers";
    }

    @GetMapping("/delete/insurer/{insurerId}")
    public String deleteInsurer(@PathVariable long insurerId) {
        insurersService.remove(insurerId);

        return "redirect:/insurers";
    }

    @GetMapping("/create/insurance/{email}")
    public String renderInsuranceForm(@ModelAttribute InsuranceDTO insuranceDTO, @PathVariable String email, Model model) {
        insuranceDTO.setEmail(email);
        model.addAttribute("insurance", insuranceDTO);

        return "create-insurance";
    }

    @PostMapping("/create/insurance/{email}")
    public String processInsuranceForm(@ModelAttribute InsuranceDTO insurance, @PathVariable String email, BindingResult result) {
        System.out.println("[LOG] create insurance -> DB (POST)");

        if (result.hasErrors()) {
            System.out.println("[ERROR] create insurance -> DB (POST)");
            return "/";
        }
        insuranceService.create(insurance);

        return "redirect:/user/" + email;
    }

    @GetMapping("/delete/insurance/{id}")
    public String deleteInsurance(@PathVariable long id, @ModelAttribute UserDTO userDTO) {
        InsuranceDTO insuranceDTO = insuranceService.getById(id);
        String mail = insuranceDTO.getEmail();
        insuranceService.remove(id);

        return "redirect:/user/"+mail;
    }

    @GetMapping("/edit/insurance/{id}")
    public String editInsurance(@ModelAttribute InsuranceDTO insuranceDTO, @PathVariable long id, Model model) {
        InsuranceDTO fetched = insuranceService.getById(id);
        insuranceMapper.updateInsuranceDTO(fetched, insuranceDTO);
        model.addAttribute("insurance", fetched);

        return "create-insurance";
    }

    @PostMapping("/edit/insurance/{id}")
    public String editInsurancePost(@ModelAttribute InsuranceDTO insurance, @PathVariable long id) {
        System.out.println(id);
        System.out.println(insurance.getContractId());
        InsuranceDTO fetched = insuranceService.getById(id);
        insurance = MergeInsuranceDTO.merge(fetched, insurance);
        insurance.setContractId(id);
        insuranceService.edit(insurance);

        return "redirect:/user/" + insurance.getEmail();
    }

    @GetMapping("/insurance/{id}")
    public String renderDetail(@ModelAttribute InsuranceDTO insuranceDTO, @PathVariable long id, Model model) {
        insuranceDTO = insuranceService.getById(id);
        model.addAttribute("insurance", insuranceDTO);

        return "insurance";
    }

    @GetMapping("/users")
    public String renderUsers(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);

        return "users";
    }
}
