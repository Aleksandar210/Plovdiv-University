package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);

    Boolean existsByFullName(String fullName);
}
