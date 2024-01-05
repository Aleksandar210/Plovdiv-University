package fmi.schooltracker.services;

import fmi.schooltracker.entities.Address;
import fmi.schooltracker.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public List<Address> getAllAddresses() {
        return this.addressesRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer id) {
        return this.addressesRepository.findById(id);
    }
}
