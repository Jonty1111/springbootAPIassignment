package com.springbootapiassignment.springbootAPIassignment.service;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import com.springbootapiassignment.springbootAPIassignment.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CoursesRepository coursesRepository;
    public List<Courses> findAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses findCoursesById(int id)
    {
        Optional<Courses> optional = coursesRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        return optional.get();
    }

    public Courses insertCourses(Courses profile) {
        if (profile == null) {
            throw new RuntimeException("Player is null...");
        }
        return coursesRepository.save(profile);
    }

    public void deleteCoursesById(int id) {
        Optional<Courses> optional = coursesRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        coursesRepository.delete(optional.get());
    }
}
