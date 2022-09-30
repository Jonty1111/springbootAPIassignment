package com.springbootapiassignment.springbootAPIassignment.repository;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
