package com.accciojob.gymmanagementsystem.Repository;


import com.accciojob.gymmanagementsystem.Entitity.Gym;
import com.accciojob.gymmanagementsystem.Entitity.Member;
import com.accciojob.gymmanagementsystem.Entitity.Trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    HashMap<Integer, List<Member>> gymMemberMap;
    HashMap<Integer,List<Trainer>> gymTrainerMap;

    HashMap<Integer, List<Trainer>> memberTrainerMap;

    HashMap<Integer,List<Gym>> trainerGymMap;
    List<Gym> gyms;
    List<Member> members;
    List<Trainer> trainers;
    public Repository(){
        gymMemberMap = new HashMap<>();
        gymTrainerMap = new HashMap<>();
        memberTrainerMap = new HashMap<>();
        trainerGymMap = new HashMap<>();
        gyms = new ArrayList<>();
        members = new ArrayList<>();
        trainers = new ArrayList<>();
    }

    public String addGym(Gym gym){
        Integer gymId = gym.getGymId();
        gyms.add(gym);
        return "gym has been added to the db";
    }

    public String addMember(Member member){
        members.add(member);
        return "member has been added to the db";
    }

    public String addTrainer(Trainer trainer){
        trainers.add(trainer);
        return "trainer has been added to the Db";
    }

    public String associateGymAndMember(Integer memberId, Integer gymId){
        List<Member> membersList = new ArrayList<>();
        if (gymMemberMap.containsKey(gymId)) {
             membersList = gymMemberMap.get(gymId);
        }
        Member memberToAdd = null;
        for(Member member:members){
            if(member.getMemberId().equals(memberId)){
                memberToAdd = member;

            }
        }
        if(memberToAdd!=null) {
            membersList.add(memberToAdd);
        }else{
            return "member not found";
        }
        gymMemberMap.put(gymId,membersList);
        return "member has been associated to the gym";
    }

    public String associateTrainerAndGym(Integer trainerId, Integer gymId){
        Trainer trainerToBeAdded = null;
        for(Trainer trainer:trainers){
            if (trainer.getTrainerId().equals(trainerId)){
                trainerToBeAdded = trainer;
                break;
            }
        }
        if(trainerToBeAdded==null){
            return "wrong trainer Id";
        }
        Gym gymToAssociate = null;
        for(Gym gym:gyms){
            if(gym.getGymId().equals(gymId)){
                gymToAssociate = gym;
            }
        }
        if(gymToAssociate == null){
            return "wrong gym Id";
        }

        List<Trainer> trainers1 = new ArrayList<>();
        if (gymTrainerMap.containsKey(gymId)) {
             trainers1 = gymTrainerMap.get(gymId);
        }

        trainers1.add(trainerToBeAdded);
        gymTrainerMap.put(gymId,trainers1);

        List<Gym> gymList = new ArrayList<>();
        if(trainerGymMap.containsKey(trainerId)) {
             gymList = trainerGymMap.get(trainerId);
        }
        gymList.add(gymToAssociate);
        trainerGymMap.put(trainerId,gymList);

        return "trainer has been associated to the gym";

    }
    public String associateMemberAndTrainer(Integer memberId, Integer trainerId){
        Trainer trainerToAdd = null;
        for (Trainer trainer:trainers){
            if (trainer.getTrainerId().equals(trainerId)){
                trainerToAdd = trainer;
            }
        }
        if(trainerToAdd == null){
            return "Trainer not found";
        }

        List<Trainer> trainerList = new ArrayList<>();

        if (memberTrainerMap.containsKey(memberId)) {
             trainerList = memberTrainerMap.get(memberId);
        }
        trainerList.add(trainerToAdd);

        memberTrainerMap.put(memberId,trainerList);
        return "trainer is associated to the member";
    }

    public Gym gymWithMostNoOfMembers(){
        int maxMembers = 0;
        Integer gymWithMaxMembers = null;
        for (Map.Entry<Integer, List<Member>> entry : gymMemberMap.entrySet()) {
            int numMembers = entry.getValue().size();
            if (numMembers > maxMembers) {
                maxMembers = numMembers;
                gymWithMaxMembers = entry.getKey();
            }
        }
        for(Gym gym:gyms){
            if (gym.getGymId().equals(gymWithMaxMembers)){
                return gym;
            }
        }
        return null;
    }
    public Member memberWithMostNoOfTrainers(){
        int maxNoOfTrainers = 0;
        Integer memberWithMaxTrainers = null;
        for (Map.Entry<Integer,List<Trainer>> entry : memberTrainerMap.entrySet()){
            int numTrainers = entry.getValue().size();
            if(numTrainers>maxNoOfTrainers){
                maxNoOfTrainers = numTrainers;
                memberWithMaxTrainers = entry.getKey();
            }

        }
        for (Member member:members){
            if(member.getMemberId().equals(memberWithMaxTrainers)){
                return member;
            }
        }
        return null;
    }
    public Integer noOfTrainersThatWorkInMoreThan2Gyms(){
        Integer countOfTrainersWorkingInMoreThanTwoGyms = 0;
        for(Map.Entry<Integer,List<Gym>> entry: trainerGymMap.entrySet() ){
            if (entry.getValue().size()>2){
                countOfTrainersWorkingInMoreThanTwoGyms++;
            }
        }
        return countOfTrainersWorkingInMoreThanTwoGyms;
    }
}
