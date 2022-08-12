package com.in28minutes.springframeworkrefresher.service;

import com.in28minutes.springframeworkrefresher.exceptions.MyException;
import com.in28minutes.springframeworkrefresher.repository.CourseRepository;
import com.in28minutes.springframeworkrefresher.repository.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private CourseRepository courseRepository;

    public MyService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course getCourse(long id) throws MyException {
        //Normally, have some sort of exception handling saying if there is no record found
        Optional<Course> course = courseRepository.findById(id);

        if (course.isEmpty()) {
            throw new MyException("No course found with id: " + id);
        }

        return course.get();
    }

    public void addCourse(Course course) {
        //Normally return a message like success
        //Have validation on if entry already exists etc etc but with generated id it shouldn't clash
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        //save will update an existing entry, if no entry it will create one
        //normally you want to check if entry is available etc
        courseRepository.save(course);
    }

    public void deleteCourse(long id) {
        //Again, checks to see if entry exists and return some sort of success/ fail message
        courseRepository.deleteById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
