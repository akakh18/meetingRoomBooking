package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
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
}
