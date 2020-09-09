package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody @Valid User user){
        userService.registerUser(user);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestParam String username,
                                      @RequestParam String password){
        User user = userService.login(username,password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
