package com.example.HomeUser.controller;

import com.example.HomeUser.model.User;
import com.example.HomeUser.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UserControllers {
    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/users")
    public String getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        try {
            return objectMapper.writeValueAsString(userService.getAllUsers());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } return String.valueOf(allUsers);
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable long id) {
        List<User> allUsersId = userService.getAllUsers();
        getUser(id);
        try {
            return objectMapper.writeValueAsString(userService.getAllUsers());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return String.valueOf(allUsersId);
    }

    @PostMapping("/newUser")
    public String newUser(@RequestBody String newUserJson){
        try{
            User user = objectMapper.readValue(newUserJson, User.class);
            userService.saveUsers(user);
        }catch (Exception e){
            return String.valueOf(HttpStatus.NOT_FOUND);
        }
        return String.valueOf(HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
       boolean delete = userService.delete(id);
        if (delete == true) {
            return String.valueOf(HttpStatus.NOT_FOUND);
        }
        return String.valueOf(HttpStatus.OK);
    }
}