package fmi.schooltracker.services;

import fmi.schooltracker.entities.Course;
import fmi.schooltracker.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CoursesRepository coursesRepository;

    @Autowired
    public CourseService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Course> getAllCourses() {
        return this.coursesRepository.findAll();
    }

    public Optional<Course> getCourseById(Integer id) {
        return this.coursesRepository.findById(id);
    }
}
