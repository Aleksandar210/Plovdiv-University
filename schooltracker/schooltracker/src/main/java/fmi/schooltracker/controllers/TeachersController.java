package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Teacher;
import fmi.schooltracker.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeachersController {
    private final TeachersRepository teachersRepository;

    @Autowired
    public TeachersController(TeachersRepository teachersRepository){
        this.teachersRepository = teachersRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return this.teachersRepository.findAll();
    }
}
