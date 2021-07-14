package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.request.RequestForm;
import com.example.meetingroombooking.model.response.SuccessResponse;
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

    @PostMapping
    public ResponseEntity<SuccessResponse> createUser(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
    }

    @GetMapping
    public ResponseEntity<List<SuccessResponse>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}
