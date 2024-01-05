package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamsRepository extends JpaRepository<Exam,Integer> {
}
