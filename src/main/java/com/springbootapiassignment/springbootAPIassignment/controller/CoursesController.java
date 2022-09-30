package com.springbootapiassignment.springbootAPIassignment.controller;

import com.springbootapiassignment.springbootAPIassignment.Entity.Courses;
import com.springbootapiassignment.springbootAPIassignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class CoursesController {


    @Autowired
    CourseService courseService;

    @GetMapping("/playersprofile-json")
//@GetMapping
    public List<Courses> getALlCoursesData()
    {

        return courseService.findAllCourses();
    }

    @GetMapping("/player/{id}")
    public Courses getCourses(@PathVariable int id)
    {

        return courseService.findCoursesById(id);
    }

    @PostMapping("/addPlayerProfile")

    public Courses addCourses(@RequestBody Courses p)
    {
        //p.setId(2);
        return courseService.insertCourses(p);
    }
    //Delete Operations
    @DeleteMapping("/deletePlayer/{id}")
    public void deleteCourses(@PathVariable int id)
    {

        courseService.deleteCoursesById(id);
    }
}
