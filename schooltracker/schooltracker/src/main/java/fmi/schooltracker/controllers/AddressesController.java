package fmi.schooltracker.controllers;

import fmi.schooltracker.entities.Address;
import fmi.schooltracker.entities.Exam;
import fmi.schooltracker.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController("/address")
public class AddressesController {
    private final AddressService addressService;

    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public ResponseEntity<List<Address>> getAllAddresses() {
        Exam ex = new Exam();
        return new ResponseEntity<>(this.addressService.getAllAddresses(), HttpStatus.OK);
    }

}
