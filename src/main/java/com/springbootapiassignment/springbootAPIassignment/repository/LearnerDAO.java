package com.springbootapiassignment.springbootAPIassignment.repository;

//import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import com.springbootapiassignment.springbootAPIassignment.Entity.Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READ
    public List<Learners> getAllLearner(){
        String getLearnerQuery = "SELECT * FROM Learners";
        return  jdbcTemplate.query(getLearnerQuery,new BeanPropertyRowMapper<Learners>(Learners.class));
    }

    // READ BY ID
    public Learners getLearnerByID(int ID){
        String getLearnerByIDQuery = "SELECT * FROM Learners WHERE learner_id = ?";
        return  jdbcTemplate.queryForObject(getLearnerByIDQuery,new BeanPropertyRowMapper<Learners>(Learners.class),new Object[]{ID});
    }

    // CREATE
    public int insertLearner(Learners leaner){
        String insertLearnerQuery = "INSERT INTO Learners VALUES(?,?,?,?,?,?)";
        // will return 1 after success and 0.

        return  jdbcTemplate.update(insertLearnerQuery, new Object[]{
                leaner.getLearner_id(),
                leaner.getCourses().getCourse_Id(),
                leaner.getLearner_first_name(),
                leaner.getLearner_last_name(),
                leaner.getLearner_email(),
                leaner.getLearner_password()
        });
    }

    // UPDATE
    public int updateLearner(Learners learner){
        String updateLearnerQuery = "UPDATE Learners "+
                "SET Course_Id = ?, learner_first_name = ?, learner_last_name = ?, learner_email = ?, learner_password = ?"+
                "Where learner_id = ?";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(updateLearnerQuery,
                new Object[]{
                        learner.getLearner_id(),
                        learner.getCourses().getCourse_Id(),
                        learner.getLearner_first_name(),
                        learner.getLearner_last_name(),
                        learner.getLearner_email(),
                        learner.getLearner_password()

                });
    }

    // Delete
    public int deleteLearner(int ID){
        String deleteLearnerQuery = "DELETE FROM Learners WHERE learner_id = ?;";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(deleteLearnerQuery, ID);
    }
}
