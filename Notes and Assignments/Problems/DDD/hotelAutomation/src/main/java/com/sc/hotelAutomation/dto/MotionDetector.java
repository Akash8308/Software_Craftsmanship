package com.sc.hotelAutomation.dto;

public class MotionDetector {
//  * Behavior: get/set(), detectMotion()
    int id;
    String name;
    Boolean input;

    public MotionDetector(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInput() {
        return input;
    }

    public void setInput(Boolean input) {
        this.input = input;
    }
}
