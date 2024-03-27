package com.accciojob.gymmanagementsystem.Entitity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;


public class Gym {
    private Integer gymId;
    private String location;


    Gym(int gymId, String location){
        this.gymId = gymId;
        this.location = location;
    }

    public Integer getGymId(){
        return gymId;
    }

    public String getLocation() {
        return location;
    }
}
