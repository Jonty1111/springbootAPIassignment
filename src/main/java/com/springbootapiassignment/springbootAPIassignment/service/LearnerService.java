package com.springbootapiassignment.springbootAPIassignment.service;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import com.springbootapiassignment.springbootAPIassignment.repository.LearnersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    LearnersRespository learnersRepository;

    //getAllPlayers
    public List<Learners> getAllLearners(){
        return learnersRepository.findAll();
    }
    public Learners findLearnerById(int id) {
        Optional<Learners> optional = learnersRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        return optional.get();
    }

    public Learners insertLearner(Learners player) {
        if (player == null) {
            throw new RuntimeException("Player is null...");
        }
        return learnersRepository.save(player);
    }

    public void deleteLearnerById(int id) {
        Optional<Learners> optional = learnersRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        learnersRepository.delete(optional.get());
    }


    public Learners assignCourse(int id, Courses profile)
    {
        Learners player=learnersRepository.findById(id).get();
        //player.setCourse_id(profile);
        return learnersRepository.save(player);
    }

    public int countNumberOfLerner(){
        return (int) learnersRepository.findAll().stream().count();
    }

    public boolean whetherIdExistInLearner(int id)
    {
        boolean exists = learnersRepository.existsById(id);
        return exists;

    }



}
