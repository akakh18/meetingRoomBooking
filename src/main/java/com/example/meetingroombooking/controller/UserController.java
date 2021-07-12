package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final List<UserDto> USERS = Arrays.asList(
            new UserDto("Avto", "avto", "123"),
            new UserDto("Dato", "dato", "123"),
            new UserDto("Leri", "leri", "123")
    );

    @GetMapping(path = "{username}")
    public UserDto getUser(@PathVariable("username") String username) {
        return USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }



}
