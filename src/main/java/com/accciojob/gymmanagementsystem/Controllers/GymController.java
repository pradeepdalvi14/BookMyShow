package com.accciojob.gymmanagementsystem.Controllers;

import com.accciojob.gymmanagementsystem.Entitity.Gym;
import com.accciojob.gymmanagementsystem.Entitity.Member;
import com.accciojob.gymmanagementsystem.Entitity.Trainer;
import com.accciojob.gymmanagementsystem.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gym")
public class GymController {


     Repository repository = new Repository();
    @PostMapping("addGym")
    public String addGym(@RequestBody Gym gym){
        String response = repository.addGym(gym);
        return response;
    }
    @PostMapping("addMember")
    public String addMember(@RequestBody Member member){
        String response = repository.addMember(member);
        return response;
    }

    @PostMapping("addTrainer")
    public String addTrainer(@RequestBody Trainer trainer){
        String response = repository.addTrainer(trainer);
        return response;
    }

    @PostMapping("associateGymAndMember")
    public String associateGymAndMember(@RequestParam("memberId")Integer memberId,
                                        @RequestParam("gymId")Integer gymId){
        String response = repository.associateGymAndMember(memberId,gymId);
        return response;
    }

    @PostMapping("associateTrainerAndGym")
    public String associateTrainerAndGym(@RequestParam("trainerId")Integer trainerId,
                                         @RequestParam("gymId")Integer gymId){
        String response = repository.associateTrainerAndGym(trainerId,gymId);
        return response;
    }

    @PostMapping("associateMemberAndTrainer")
    public String associateTrainerAndMember(@RequestParam("memberId")Integer trainerId,
                                            @RequestParam("trainerId")Integer memberId){
        String response = repository.associateMemberAndTrainer(trainerId,memberId);
        return response;
    }

    @GetMapping("gymWithMostNoOfMembers")
    public String gymWithMostNoOfMembers(){
       Gym gym = repository.gymWithMostNoOfMembers();
       return gym.getGymId()+" "+gym.getLocation();
    }

    @GetMapping("memberWithMostNoOfTrainers")
    public String memberWithMostNoOfTrainers(){
        Member member = repository.memberWithMostNoOfTrainers();
        return member.getMemberId()+" "+member.getGym();
    }

    @GetMapping("noOfTrainersThatWorkInMoreThan2Gyms")
    public Integer trainersThatWorkInMoreThan2Gyms(){
        Integer ans = repository.noOfTrainersThatWorkInMoreThan2Gyms();
        return ans;
    }

}
