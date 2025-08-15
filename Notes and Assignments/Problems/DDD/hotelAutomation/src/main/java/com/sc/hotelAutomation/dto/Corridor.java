package com.sc.hotelAutomation.dto;

import java.time.LocalTime;
import java.util.List;

public class Corridor {
    int id;
    String name;
    List<Light> light;
    List<Ac> ac;
    LocalTime time;
}
