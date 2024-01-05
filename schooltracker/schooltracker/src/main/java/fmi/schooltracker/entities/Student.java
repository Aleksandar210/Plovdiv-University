package fmi.schooltracker.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

 enum Status {
    active,
    sick_leave,
    vacation,
    non_active
}

@Data
@Getter
@Setter
@Table(name = "Students")
@Entity
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "phone")
    private String egn;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private char gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    private Parent parent;

    @Column(name = "date_of_join")
    private Date date_of_join;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @Column(name = "current_status", columnDefinition = "ENUM('active', 'sick_leave', 'vacation', 'non_active')")
    @Enumerated(EnumType.STRING)
    private Status current_status;


}
