package com.example.meetingroombooking.model.response;

import com.example.meetingroombooking.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse {
    //@JsonProperty(namespace = "result")
    private final Object result;

    public SuccessResponse(Object result) {
        this.result = result;
    }

    public Object getUser() {
        return result;
    }
}
