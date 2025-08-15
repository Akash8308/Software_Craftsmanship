package com.sc.hotelAutomation.dto;

import com.sc.hotelAutomation.valueobject.PowerStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ac {
    String id;
    PowerStatus powerStatus;
    LocalTime countDownSinceLastMotionDetected;
}
