package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendance,Integer> {
}
