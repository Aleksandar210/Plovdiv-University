package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Exam;
import fmi.schooltracker.repositories.ExamsRepository;
import fmi.schooltracker.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ExamsController {
    private final ExamService examService;

    @Autowired
    public ExamsController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/exams")
    public ResponseEntity<List<Exam>> getAllExams() {
        return new ResponseEntity<>(this.examService.getAllExams(), HttpStatus.OK);
    }
}
