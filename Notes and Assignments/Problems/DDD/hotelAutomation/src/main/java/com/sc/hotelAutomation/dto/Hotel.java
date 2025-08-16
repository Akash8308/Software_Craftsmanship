package com.sc.hotelAutomation.dto;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    int id;
    String name;
    List<Floor> floor;

    public Hotel(int id, List<Floor> floor, String name) {
        this.id = id;
        this.name = name;
        this.floor = new ArrayList<>();
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

    public List<Floor> getFloor() {
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
