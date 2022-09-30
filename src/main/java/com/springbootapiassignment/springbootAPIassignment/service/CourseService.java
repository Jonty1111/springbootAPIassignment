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
    private CoursesRepository profileRepository;
    public List<Courses> findAllCourses() {
        return profileRepository.findAll();
    }

    public Courses findCoursesById(int id)
    {
        Optional<Courses> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        return optional.get();
    }

    public Courses insertCourses(Courses profile) {
        if (profile == null) {
            throw new RuntimeException("Player is null...");
        }
        return profileRepository.save(profile);
    }

    public void deleteCoursesById(int id) {
        Optional<Courses> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Player not found...");
        }
        profileRepository.delete(optional.get());
    }
}
