package com.example.HomeUser.controller;

import com.example.HomeUser.model.User;
import com.example.HomeUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllers {
    @Autowired
    UserService userService;
    @Autowired
    User user;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("User",allUsers);
        return allUsers.toString();
    }

    @GetMapping("/newusers")
    public String createUser (Model model){
        model.addAttribute("user",new User());
        return String.valueOf(userService.getAllUsers());
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String saveuser(User user){
        userService.saveUsers(user);
        return "redirect:/users";
    }


}