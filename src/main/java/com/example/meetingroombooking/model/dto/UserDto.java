package com.example.meetingroombooking.model.dto;


import com.example.meetingroombooking.model.entity.User;

public class UserDto {
    private final String username;
    private final String fullName;
    private final String password;


    public UserDto(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public UserDto(User user) {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.password = user.getPassword();
    }

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setFullName(fullName);
        user.setPassword(password);

        return user;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
