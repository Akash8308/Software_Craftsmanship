package com.sc.hotelAutomation.dto;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int id;
    List<Corridor> mainCorridor;
    List<Corridor> subCorridor;

    public Floor(int id) {
        this.id = id;
        this.mainCorridor = new ArrayList<>();
        this.subCorridor = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Corridor> getMainCorridor() {
        return mainCorridor;
    }

    public void setMainCorridor(List<Corridor> mainCorridor) {
        this.mainCorridor = mainCorridor;
    }

    public List<Corridor> getSubCorridor() {
        return subCorridor;
    }

    public void setSubCorridor(List<Corridor> subCorridor) {
        this.subCorridor = subCorridor;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", mainCorridor=" + mainCorridor +
                ", subCorridor=" + subCorridor +
                '}';
    }
}
