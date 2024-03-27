package com.accciojob.gymmanagementsystem.Entitity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;


public class Trainer {
    private Integer trainerId;
    private String name;

     Trainer(Integer trainerId,String name) {
        this.trainerId = trainerId;
        this.name = name;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }
}
