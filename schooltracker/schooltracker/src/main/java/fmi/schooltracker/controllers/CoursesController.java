package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Course;
import fmi.schooltracker.repositories.CoursesRepository;
import fmi.schooltracker.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {
    private final CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }
}
