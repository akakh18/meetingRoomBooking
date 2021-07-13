package com.example.meetingroombooking.model.dto;

public class Dates {
    private String starting;
    private String ending;

    public Dates() {}

    public Dates(String starting, String ending) {
        this.starting = starting;
        this.ending = ending;
    }

    public String getStarting() {
        return starting;
    }

    public String getEnding() {
        return ending;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }
}
