package com.sc.hotelAutomation.dto;

import java.util.List;

public class Hotel {
    int id;
    String name;
    List<Floor> floor;

    public Hotel(int id, List<Floor> floor, String name) {
        this.id = id;
        this.floor = floor;
        this.name = name;
    }
}
