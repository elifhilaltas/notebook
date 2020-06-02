package com.notebook.controller;

import com.notebook.domain.User;
import com.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void postUser(@RequestBody User user){
        userService.add(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(required = true) Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id){
        userService.delete(id);

    }
}
