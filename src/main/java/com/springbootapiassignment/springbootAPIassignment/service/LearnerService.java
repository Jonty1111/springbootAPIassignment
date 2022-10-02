package com.springbootapiassignment.springbootAPIassignment.service;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import com.springbootapiassignment.springbootAPIassignment.repository.LearnersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    /*******QUERIES********/
    @Transactional
    public List<Learners> findByEmailAddressAndLastname(String email, String last_name){
        return learnersRepository.findByEmailAddressAndLastname(email,last_name);
    }

    @Transactional
    public List<Learners> findDistinctLeanerByLastnameOrFirstname(String first_name, String last_name){
        return learnersRepository.findDistinctLeanerByLastnameOrFirstname(first_name,last_name);
    }

    @Transactional
    public List<Learners> findByLastnameIgnoreCase(String last_name){
        return learnersRepository.findByLastnameIgnoreCase(last_name);
    }

    @Transactional
    public List<Learners> findByLastnameOrderByFirstnameAsc(String last_name){
        return learnersRepository.findByLastnameOrderByFirstnameAsc(last_name);
    }


}
