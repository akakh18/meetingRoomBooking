package com.example.meetingroombooking.model.request;

public class RequestForm<T> {
    private final T data;

    public RequestForm(T request) {
        this.data = request;
    }

    public T getRequest() {
        return data;
    }
}
