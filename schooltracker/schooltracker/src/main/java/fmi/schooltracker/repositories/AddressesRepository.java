package fmi.schooltracker.repositories;

import fmi.schooltracker.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Integer> {
}
