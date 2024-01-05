package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepository extends JpaRepository<Parent,Integer> {

}
