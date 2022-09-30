package com.springbootapiassignment.springbootAPIassignment.controller;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import com.springbootapiassignment.springbootAPIassignment.service.CourseService;
import com.springbootapiassignment.springbootAPIassignment.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jonty1")
public class LearnerController {

    @Autowired
    LearnerService service;


    @Autowired
    CourseService coursesService;
    @GetMapping("/players-json")
    public List<Learners> getAllLeanerData()
    {

        return service.getAllLearners();
    }

    @GetMapping("/player/{id}")
    public Learners getLearner(@PathVariable int id)
    {

        return service.findLearnerById(id);
    }

    @PostMapping("/addPlayer")
    public Learners addLearners(@RequestBody Learners p)
    {
        //p.setId(2);
        return service.insertLearner(p);
    }


    //Delete Operations
    @DeleteMapping("/deletePlayer/{id}")
    public void deleteLearner(@PathVariable int id)
    {

        service.deleteLearnerById(id);
    }

    //OneToOneRelations
    @PutMapping("/{id}/profiles/{profile_id}")
    public Learners assignDetails(@PathVariable int id,@PathVariable int profile_id)
    {
        Courses playerProfile= coursesService.findCoursesById(profile_id);
        System.out.println(playerProfile);
        return service.assignCourse(id,playerProfile);
    }

    @GetMapping("/count")
    public int countLearners(){
        return service.countNumberOfLerner();
    }
    @GetMapping("/idExistInsideLearner/{id}")
    public boolean idExistInsideLearner(@PathVariable int id)
    {
        return service.whetherIdExistInLearner(id);
    }


    /* what we are basically doing is simply assign the object details in another object like her in this case we are putting the PlayerProfile object in Player Object
    public Player assignProfile(int id, PlayerProfile profile)
    {
        Player player=playerRepository.findById(id).get();
        player.setPlayerProfile(profile);
        return playerRepository.save(player);
    }
     */


}
