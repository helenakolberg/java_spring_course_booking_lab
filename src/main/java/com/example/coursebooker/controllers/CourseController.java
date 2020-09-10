package com.example.coursebooker.controllers;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<List<Course>> deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        courseRepository.save(course);
        return new ResponseEntity(course, HttpStatus.CREATED);
    }
}
