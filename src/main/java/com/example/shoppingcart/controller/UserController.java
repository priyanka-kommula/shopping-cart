package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.User;
import com.example.shoppingcart.model.UserRequest;
import com.example.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("shopping/users")
    public @ResponseBody User createUser(@RequestBody UserRequest user) {


        return userService.createUser(user);
    }

//    @GetMapping("shopping/users/{id}")
//    public @ResponseBody User getUser() {
//
//        return null;
    }

