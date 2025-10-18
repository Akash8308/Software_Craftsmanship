package com.sc.hotelAutomation.dto;

public class MotionDetector {
    int id;
    String name;
    boolean input;

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

    public boolean detectMotion(){
        return true;
    }
}
