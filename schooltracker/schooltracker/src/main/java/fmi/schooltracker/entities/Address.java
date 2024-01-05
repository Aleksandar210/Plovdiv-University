package fmi.schooltracker.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name = "Addresses")
@Entity
public class Address {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "postal_code")
    private Integer  postal_code;

    @Column(name = "street_name")
    private String street_name;
    @Column(name = "street_number")
    private Integer street_number;
}
