package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {

}
