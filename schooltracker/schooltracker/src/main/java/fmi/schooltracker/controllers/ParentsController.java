package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Parent;
import fmi.schooltracker.repositories.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentsController {
    private final ParentsRepository parentsRepository;

    @Autowired
    public ParentsController(ParentsRepository parentsRepository){
        this.parentsRepository = parentsRepository;
    }

    @GetMapping("/parents")
    public List<Parent> getParents() {
        return this.parentsRepository.findAll();
    }


}
