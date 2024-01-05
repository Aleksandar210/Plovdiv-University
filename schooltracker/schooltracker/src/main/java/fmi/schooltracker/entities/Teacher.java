package fmi.schooltracker.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

enum TeacherStatus {
    sick_leave,
    vacation,
    on_work
}
@Data
@Getter
@Setter
@Table(name = "Teachers")
@Entity
public class Teacher {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;

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

    @Column(name = "date_of_join")
    private Date date_of_join;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "current_status", columnDefinition = "ENUM('sick_leave', 'vacation', 'on_work')")
    @Enumerated(EnumType.STRING)
    private TeacherStatus current_status;
}
