package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository/*, PasswordEncoder passwordEncoder*/) {
        //this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDto createNewUser(UserDto user) {
        userRepository.insertUser(user.getUsername(), user.getFullName(), user.getPassword());
        return user;
    }

    public List<UserDto> getAllUsers() {
        ArrayList<UserDto> result = new ArrayList<>();

        List<User> users = userRepository.findAll();

        for(User user : users) {
            result.add(new UserDto(user));
        }

        return result;
    }

    public Optional<User> getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = (String)authentication.getPrincipal();
//
//        return userRepository.getUserByUsername(username);
        return Optional.empty();
    }
}
