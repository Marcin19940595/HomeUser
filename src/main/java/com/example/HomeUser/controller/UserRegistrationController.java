package com.example.HomeUser.controller;

import com.example.HomeUser.controller.dto.UserRegistrationDto;
import com.example.HomeUser.model.User;
import com.example.HomeUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    @GetMapping("/registry")
    public String showRegistrationForm(){
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        User user = userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
