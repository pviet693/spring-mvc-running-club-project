package com.vietvippro.rungroop.controller;

import com.vietvippro.rungroop.dto.RegistrationDto;
import com.vietvippro.rungroop.models.UserEntity;
import com.vietvippro.rungroop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register/save")
    public String saveUser(
            @Valid @ModelAttribute("user") RegistrationDto registrationDto,
            BindingResult result,
            Model model
    ) {
        UserEntity existingUserEmail = userService.findByEmail(registrationDto.getEmail());
        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }
        UserEntity existingUserUsername = userService.findByUsername(registrationDto.getUsername());
        if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }
        if(result.hasErrors()) {
            model.addAttribute("user", registrationDto);
            return "register";
        }

        System.out.println(registrationDto);
        userService.saveUser(registrationDto);
        return "redirect:/clubs?success";

//        if (result.hasErrors()) {
//            model.addAttribute("user", registrationDto);
//            return "register";
//        }
//
//        UserEntity existingUserEmail = userService.findByEmail(registrationDto.getEmail());
//        if (
//                existingUserEmail != null && existingUserEmail.getEmail() != null
//                && !existingUserEmail.getEmail().isEmpty()
//        ) {
//            result.rejectValue("email", "There is already a user with this email/username");
//            return "redirect:/register?fail";
//        }
//
//        UserEntity existingUserUsername = userService.findByUsername(registrationDto.getUsername());
//        if (
//                existingUserUsername != null && existingUserUsername.getUsername() != null
//                        && !existingUserEmail.getUsername().isEmpty()
//        ) {
//            result.rejectValue("username", "There is already a user with this email/username");
//            return "redirect:/register?fail";
//        }
//
//        userService.saveUser(registrationDto);
//        return "redirect:/clubs?success";
    }
}
