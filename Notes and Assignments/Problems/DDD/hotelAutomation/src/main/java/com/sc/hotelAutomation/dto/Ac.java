package com.sc.hotelAutomation.dto;

import com.sc.hotelAutomation.valueobject.PowerStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ac {
    String id;
    PowerStatus powerStatus;
    LocalTime countDownSinceLastMotionDetected;

    public Ac(String id, PowerStatus powerStatus, LocalTime countDownSinceLastMotionDetected) {
        this.id = id;
        this.powerStatus = powerStatus;
        this.countDownSinceLastMotionDetected = countDownSinceLastMotionDetected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) {
        this.powerStatus = powerStatus;
    }

    public LocalTime getCountDownSinceLastMotionDetected() {
        return countDownSinceLastMotionDetected;
    }

    public void setCountDownSinceLastMotionDetected(LocalTime countDownSinceLastMotionDetected) {
        this.countDownSinceLastMotionDetected = countDownSinceLastMotionDetected;
    }


    @Override
    public String toString() {
        return "Ac{" +
                "id='" + id + '\'' +
                ", powerStatus=" + powerStatus +
                ", countDownSinceLastMotionDetected=" + countDownSinceLastMotionDetected +
                '}';
    }

}
