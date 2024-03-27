package com.accciojob.gymmanagementsystem.Entitity;

import com.accciojob.gymmanagementsystem.Repository.Repository;

import java.util.List;

public class Member {
    private Integer memberId;

   private Integer gymId;
    Member(Integer memberId,Integer gymId){
        this.memberId = memberId;
        this.gymId = gymId;
    }

    public Integer getMemberId(){
        return memberId;
    }

    public Integer getGym(){
        return gymId;
    }
}
