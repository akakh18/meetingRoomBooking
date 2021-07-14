package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.model.response.SuccessResponse;
import com.example.meetingroombooking.repository.UserRepository;
import com.example.meetingroombooking.security.DataUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public SuccessResponse createNewUser(UserDto user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent())
            throw new RuntimeException("User already exists");

        userRepository.save(user.toEntity());
        return new SuccessResponse(user);
    }

    public List<SuccessResponse> getAllUsers() {
        ArrayList<SuccessResponse> result = new ArrayList<>();

        List<User> users = userRepository.findAll();

        for(User user : users) {
            result.add(new SuccessResponse(new UserDto(user)));
        }

        return result;
    }

    public SuccessResponse getUserResponseByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("No such user found"));

        return new SuccessResponse(new UserDto(user));
    }

    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((DataUserDetails) authentication.getPrincipal()).getUsername();

        System.out.printf("Username: %s\n", username);
        return userRepository.findByUsername(username);
    }
}
