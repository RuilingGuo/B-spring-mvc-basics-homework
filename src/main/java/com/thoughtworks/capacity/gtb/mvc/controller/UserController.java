package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestParam
                                      @NotBlank(message = "用户名不为空")
                                      @Size(min = 3, max = 10, message = "用户名不合法，长度应为3到10位")
                                      @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "用户名不合法，用户名只能由字母、数字、下划线组成")
                                      @Valid
                                              String username,
                                      @RequestParam
                                      @NotBlank(message = "密码不为空")
                                      @Size(min = 5, max = 12, message = "密码不合法，密码长度应为5到12位置")
                                      @Valid
                                              String password) {
        User user = userService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
