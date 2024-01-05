package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Course,Integer> {

}
