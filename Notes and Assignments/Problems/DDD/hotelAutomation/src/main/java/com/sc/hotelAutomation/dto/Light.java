package com.sc.hotelAutomation.dto;

import com.sc.hotelAutomation.valueobject.PowerStatus;

import java.time.LocalTime;

public class Light {
    String id;
    PowerStatus powerStatus;
    LocalTime countDownSinceLastMotionDetected;

    public Light(String id) {
        this.id = id;
        this.powerStatus = PowerStatus.OFF;
        this.countDownSinceLastMotionDetected = LocalTime.now();
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
        return "Light{" +
                "id='" + id + '\'' +
                ", powerStatus=" + powerStatus +
                ", countDownSinceLastMotionDetected=" + countDownSinceLastMotionDetected +
                '}';
    }
}
