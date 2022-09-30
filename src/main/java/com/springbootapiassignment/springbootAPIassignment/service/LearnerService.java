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
    LearnersRespository playerRepository;

    //getAllPlayers
    public List<Learners> getAllLearners(){
        return playerRepository.findAll();
    }
    public Learners findLearnerById(int id) {
        Optional<Learners> optional = playerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        return optional.get();
    }

    public Learners insertLearner(Learners player) {
        if (player == null) {
            throw new RuntimeException("Player is null...");
        }
        return playerRepository.save(player);
    }

    public void deleteLearnerById(int id) {
        Optional<Learners> optional = playerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        playerRepository.delete(optional.get());
    }


    public Learners assignCourse(int id, Courses profile)
    {
        Learners player=playerRepository.findById(id).get();
        //player.setCourse_id(profile);
        return playerRepository.save(player);
    }
}
