package com.springbootapiassignment.springbootAPIassignment.repository;

//import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READ
    public List<Courses> getAllCourses(){
        String getCourseQuery = "SELECT * FROM Courses";
        return  jdbcTemplate.query(getCourseQuery,new BeanPropertyRowMapper<Courses>(Courses.class));
    }

    // READ BY ID
    public Courses getCourseByID(int ID){
        String getCourseByIDQuery = "SELECT * FROM Courses WHERE course_Id = ?";
       return  jdbcTemplate.queryForObject(getCourseByIDQuery,new BeanPropertyRowMapper<Courses>(Courses.class),new Object[]{ID});
    }

    // CREATE
    public int insertCourse(Courses course){
        String insertCourseQuery = "INSERT INTO Courses VALUES(?,?,?)";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(insertCourseQuery, new Object[]{
                course.getCourse_Id(),
                course.getCourse_name(),
                course.getCourse_description()
        });
    }

    // UPDATE
    public int updateCourse(Courses course){
        String updateCourseQuery = "UPDATE Courses "+
                "SET course_name = ?, course_description = ?"+
                "Where course_Id = ?";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(updateCourseQuery,
                new Object[]{
                        course.getCourse_Id(),
                        course.getCourse_name(),
                        course.getCourse_description()
                });
    }

    // Delete
    public int deleteCourse(int ID){
        String deleteCourseQuery = "DELETE FROM Courses WHERE course_Id = ?;";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(deleteCourseQuery, ID);
    }

}
