package fmi.schooltracker.services;

import fmi.schooltracker.entities.Exam;
import fmi.schooltracker.entities.Exam_Result;
import fmi.schooltracker.entities.Exam_Type;
import fmi.schooltracker.repositories.ExamResultsRepository;
import fmi.schooltracker.repositories.ExamTypesRepository;
import fmi.schooltracker.repositories.ExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    private final ExamsRepository examsRepository;
    private final ExamResultsRepository examResultsRepository;
    private  final ExamTypesRepository examTypesRepository;

    @Autowired
    public ExamService(ExamsRepository examsRepository, ExamResultsRepository examResultsRepository, ExamTypesRepository examTypesRepository) {
        this.examsRepository = examsRepository;
        this.examResultsRepository = examResultsRepository;
        this.examTypesRepository = examTypesRepository;
    }

    public List<Exam> getAllExams() {
        return this.examsRepository.findAll();
    }

    public Optional<Exam> getExamById(Integer id) {
        return this.examsRepository.findById(id);
    }

    public List<Exam_Type> getAllExamTypes() {
        return this.examTypesRepository.findAll();
    }

    public Optional<Exam_Type> getExamTypeId(Integer id) {
        return this.examTypesRepository.findById(id);
    }

    public List<Exam_Result> getAllExamResults() {
        return this.examResultsRepository.findAll();
    }

    public Optional<Exam_Result> getExamResultById(Integer id) {
        return this.examResultsRepository.findById(id);
    }


}
