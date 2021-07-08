package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final List<UserDto> USERS = Arrays.asList(
            new UserDto(1, "Avto"),
            new UserDto(2, "Dato"),
            new UserDto(3, "Leri")
    );

    @GetMapping(path = "{userId}")
    public UserDto getUser(@PathVariable("userId") Integer userId) {
        return USERS.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
    }


    @PostMapping
    public void createUser(@RequestBody UserDto user) {

    }



}
