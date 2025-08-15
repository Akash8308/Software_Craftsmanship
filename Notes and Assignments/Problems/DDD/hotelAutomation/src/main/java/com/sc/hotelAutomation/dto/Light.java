package com.sc.hotelAutomation.dto;

import com.sc.hotelAutomation.valueobject.PowerStatus;

import java.time.LocalTime;

public class Light {
    int id;
    String power;
    PowerStatus powerStatus;
    LocalTime countDownSinceLastMotionDetected;
}
