package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Exam_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTypesRepository extends JpaRepository<Exam_Type, Integer> {
}
