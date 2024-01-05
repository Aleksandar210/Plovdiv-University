package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Student;
import fmi.schooltracker.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
    private final StudentsRepository studentRepository;

    @Autowired
    public StudentsController(StudentsRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }
}
