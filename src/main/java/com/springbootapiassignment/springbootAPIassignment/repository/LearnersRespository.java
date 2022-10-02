package com.springbootapiassignment.springbootAPIassignment.repository;

import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnersRespository extends JpaRepository<Learners,Integer> {


    @Modifying
    @Query("SELECT l FROM Learners l Where l.learner_email = :learner_email AND l.learner_last_name = :learner_last_name" )
    List<Learners> findByEmailAddressAndLastname(@Param("learner_email") String learner_email, @Param("learner_last_name") String learner_last_name );

    @Modifying
    @Query("SELECT DISTINCT l FROM Learners l Where l.learner_first_name = :learner_first_name OR l.learner_last_name = :learner_last_name")
    List<Learners> findDistinctLeanerByLastnameOrFirstname(@Param("learner_first_name") String learner_first_name, @Param("learner_last_name") String learner_last_name );

    @Modifying
    @Query("SELECT l FROM Learners l Where UPPER(l.learner_last_name) = UPPER(:learner_last_name)")
    List<Learners> findByLastnameIgnoreCase( @Param("learner_last_name") String learner_last_name );

    @Modifying
    @Query("SELECT l FROM Learners l Where l.learner_last_name = :learner_last_name ORDER BY l.learner_first_name ASC")
    List<Learners> findByLastnameOrderByFirstnameAsc(@Param("learner_last_name") String learner_last_name );


}
