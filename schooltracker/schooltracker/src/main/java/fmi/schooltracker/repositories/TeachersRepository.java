package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Integer> {
}
