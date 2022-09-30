package com.springbootapiassignment.springbootAPIassignment.repository;

import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnersRespository extends JpaRepository<Learners,Integer> {
}
