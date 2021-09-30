package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void save(){
        userService.saveQVersion();
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.findAll();
    }
}
