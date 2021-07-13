package com.example.meetingroombooking.model.request;

public class RequestForm<T> {
    private final T request;

    public RequestForm(T request) {
        this.request = request;
    }

    public T getRequest() {
        return request;
    }
}
