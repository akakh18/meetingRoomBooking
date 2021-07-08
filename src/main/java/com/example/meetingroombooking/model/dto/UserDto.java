package com.example.meetingroombooking.model.dto;


// Just for testing
public class UserDto {
    private Integer userId;
    private String name;

    public UserDto(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
