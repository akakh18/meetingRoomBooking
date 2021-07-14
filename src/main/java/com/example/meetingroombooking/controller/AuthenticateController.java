package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.security.DataUserDetailsService;
import com.example.meetingroombooking.security.JwtUtil;
import com.example.meetingroombooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/session")
public class AuthenticateController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final DataUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticateController(UserService userService, AuthenticationManager authenticationManager,
                                  DataUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDto user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("wrong_credentials");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        String jwt = jwtUtil.generateToken(userDetails);

        System.out.printf("JWT, %s: \n", jwt);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserResponseByUsername(user.getUsername()));
    }
}
