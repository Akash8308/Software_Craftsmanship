package com.sc.hotelAutomation.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Corridor {
    int id;
    String name;
    List<Light> light;
    List<Ac> ac;
    LocalTime time;

    public Corridor(int id, String name) {
        this.id = id;
        this.name = name;
        this.light = new ArrayList<>();
        this.ac = new ArrayList<>();
        this.time = LocalTime.now();
    }
}
