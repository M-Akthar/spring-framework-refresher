package com.in28minutes.springframeworkrefresher.controller;

import com.in28minutes.springframeworkrefresher.exceptions.MyException;
import com.in28minutes.springframeworkrefresher.repository.model.Course;
import com.in28minutes.springframeworkrefresher.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService service;

    @GetMapping(path = "/course/{id}")
    public Course getCourse(@PathVariable long id) throws MyException {
        return service.getCourse(id);
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course course) {
        service.addCourse(course);
    }

    @PutMapping("/course")
    public void updateCourse(@RequestBody Course course) {
        service.updateCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable long id) {
        service.deleteCourse(id);
    }

    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

}
